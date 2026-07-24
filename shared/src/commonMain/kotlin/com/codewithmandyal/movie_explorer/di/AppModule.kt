package com.codewithmandyal.movie_explorer.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    networkModule,
    homeModule,
    detailsModule,
    listingModule
)