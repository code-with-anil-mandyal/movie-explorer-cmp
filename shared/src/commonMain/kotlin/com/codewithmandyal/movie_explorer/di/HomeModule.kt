package com.codewithmandyal.movie_explorer.di

import com.codewithmandyal.movie_explorer.data.remote.MovieApiService
import com.codewithmandyal.movie_explorer.data.remote.MovieApiServiceImpl
import com.codewithmandyal.movie_explorer.data.repository.HomeRepositoryImpl
import com.codewithmandyal.movie_explorer.domain.repository.HomeRepository
import com.codewithmandyal.movie_explorer.domain.usecase.GetDiscoverUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetNowPlayingMoviesUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetPopularUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetTopRatedMoviesUseCase
import com.codewithmandyal.movie_explorer.features.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    single<MovieApiService> {
        MovieApiServiceImpl(get())
    }


    single<HomeRepository> {
        HomeRepositoryImpl(
            get()
        )
    }

    factory {
        GetDiscoverUseCase(get())
    }



    factory {
        GetTopRatedMoviesUseCase(get())
    }


    factory {
        GetNowPlayingMoviesUseCase(get())
    }

    factory {
        GetPopularUseCase(get())
    }



    viewModel {
        HomeViewModel(get(), get(), get(), get())
    }
}