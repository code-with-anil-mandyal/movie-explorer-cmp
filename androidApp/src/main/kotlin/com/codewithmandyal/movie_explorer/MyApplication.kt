package com.codewithmandyal.movie_explorer

import android.app.Application
import com.codewithmandyal.movie_explorer.di.initKoin
import com.codewithmandyal.movie_explorer.utils.AppContextHolder

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
        AppContextHolder.context = applicationContext
    }
}