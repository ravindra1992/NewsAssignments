package com.example.newsassignment.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.newsassignment.R
import com.google.android.material.snackbar.Snackbar

fun Context.showSnackBar(message: String): Snackbar {
    val sb = Snackbar.make((this as Activity).findViewById<View>(android.R.id.content), message, Snackbar.LENGTH_LONG)
    sb.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
    val textView = sb.view.findViewById<TextView>(R.id.snackbar_text)
    textView.setTextColor(Color.RED)
    sb.show()
    return sb
}

fun ImageView.loadImage(url:String){
    Glide.with(context)
        .load(url)
        .into(this)
}