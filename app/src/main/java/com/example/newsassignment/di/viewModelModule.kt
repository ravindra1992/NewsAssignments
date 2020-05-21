package com.example.newsassignment.di

import com.example.newsassignment.viewmodel.NewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        NewsViewModel(get())
    }
}