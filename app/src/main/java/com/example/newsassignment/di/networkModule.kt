package com.example.newsassignment.di

import com.example.newsassignment.network.RestClient
import com.example.newsassignment.network.RestClient.Services
import org.koin.dsl.module

val networkModule = module {
    single { RestClient }
    single { Services() }
}