package com.codewithmandyal.movie_explorer.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModules)
    }
}