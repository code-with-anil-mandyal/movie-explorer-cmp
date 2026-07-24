package com.codewithmandyal.movie_explorer.di

import com.codewithmandyal.movie_explorer.data.remote.MovieApiService
import com.codewithmandyal.movie_explorer.data.remote.MovieApiServiceImpl
import com.codewithmandyal.movie_explorer.data.repository.HomeRepositoryImpl
import com.codewithmandyal.movie_explorer.data.repository.ListingRepositoryImpl
import com.codewithmandyal.movie_explorer.domain.repository.HomeRepository
import com.codewithmandyal.movie_explorer.domain.repository.ListingRepository
import com.codewithmandyal.movie_explorer.domain.usecase.GetTopRatedMoviesUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetTrendingUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.SearchUseCase
import com.codewithmandyal.movie_explorer.features.listingScreen.ListingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val listingModule = module {

    single<MovieApiService> {
        MovieApiServiceImpl(get())
    }

    single<ListingRepository> {
        ListingRepositoryImpl(
            get()
        )
    }


    factory {
        GetTopRatedMoviesUseCase(get())
    }

    factory {
        GetTrendingUseCase(get())
    }

    factory {
        SearchUseCase(get())
    }



    viewModel {
        ListingViewModel(get(), get(),get(), get())
    }
}