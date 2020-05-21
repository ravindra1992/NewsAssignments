package com.example.newsassignment.repo

import androidx.lifecycle.MutableLiveData
import com.example.newsassignment.App
import com.example.newsassignment.R
import com.example.newsassignment.db.cache.DbCache
import com.example.newsassignment.db.entity.NewsDao
import com.example.newsassignment.model.Article
import com.example.newsassignment.network.ApiStatus.CheckStatus
import com.example.newsassignment.network.RestClient
import com.example.newsassignment.utils.Constants.api_key
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewsRepo(private val restClient: RestClient) {

    private val userList = MutableLiveData<List<Article>>()
    private val errorMess = MutableLiveData<String>()
    private var job: Job? = null
    var newsDao: NewsDao = DbCache.getInstance().newsDao()
    init {
        loadApi()
    }

    private fun loadApi() {
        job= CoroutineScope(Dispatchers.IO).launch {
            try {
                restClient.Services().getNews(api_key).await().let {
                    if (it.isSuccessful && it.body()?.status == "ok") {
                        val result = it.body()!!.articles
                        result?.let {
                            newsDao.deleteAllNews()
                            newsDao.saveAndUpdate(result)
                            userList.postValue(result)
                        }

                    } else {
                        userList.postValue(newsDao.getAllNews())
                        errorMess.postValue(CheckStatus(it.code(), it.errorBody()))
                    }
                }
            } catch (e: Exception) {
                userList.postValue(newsDao.getAllNews())
                e.printStackTrace()
                errorMess.postValue(App.appContext?.getString(R.string.no_internet))
            }
        }
    }

    fun getSuggestions(): MutableLiveData<List<Article>> {
        return userList
    }

    fun getErrorMessage(): MutableLiveData<String> {
        return errorMess
    }
    fun onCleared(){
        job?.cancel()
    }
}