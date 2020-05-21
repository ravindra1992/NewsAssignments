package com.example.newsassignment.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.newsassignment.R
import com.example.newsassignment.model.Article
import com.example.newsassignment.utils.loadImage
import kotlinx.android.synthetic.main.news_list_adapter.view.*
import androidx.core.util.Pair

class NewsListAdapter (var list: List<Article>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_list_adapter, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val context: Context =itemView.context
        fun bindItems(model: Article) {
            itemView.apply {
                news.loadImage(model.urlToImage?:"")
                title.text = model.title?:"N.A"
                description.text = model.description?:"N.A"
            }.setOnClickListener {
                val sharedIntent = Intent(context, DetailNewsActivity::class.java)
                    .putExtra("image_url",model.urlToImage)
                    .putExtra("title",model.title)
                    .putExtra("description",model.description)
//                val pair1 = Pair.create(itemView.news as View, "news")
//                val pair2 = Pair.create(itemView.title as View, "title")
//                val pair3 = Pair.create(itemView.description as View, "description")
//                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, pair1, pair2,pair3)
                 context.startActivity(sharedIntent)

            }
        }
    }

}