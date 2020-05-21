package com.example.newsassignment.di

import com.example.newsassignment.repo.NewsRepo
import org.koin.dsl.module

val appModule = module {
    single { NewsRepo(get()) }

}