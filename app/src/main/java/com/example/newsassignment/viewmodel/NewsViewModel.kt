package com.example.newsassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsassignment.model.Article
import com.example.newsassignment.repo.NewsRepo

class NewsViewModel(private val repo: NewsRepo) : ViewModel() {

    fun getNewsInfo(): MutableLiveData<List<Article>> {
        return repo.getSuggestions()
    }
    fun getErrorMessage(): MutableLiveData<String> {
        return repo.getErrorMessage()
    }

    override fun onCleared() {
        repo.onCleared()
        super.onCleared()
    }
}