package com.example.newsassignment.di

import com.example.newsassignment.db.cache.DbCache
import com.example.newsassignment.db.cache.DbCache.Companion.getInstance
import org.koin.dsl.module

val databaseModule = module {
    single { DbCache }
    single { getInstance() }
}