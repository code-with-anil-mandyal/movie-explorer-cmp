package com.codewithmandyal.movie_explorer.di

import com.codewithmandyal.movie_explorer.data.repository.DetailsRepositoryImpl
import com.codewithmandyal.movie_explorer.domain.repository.DetailsRepository
import com.codewithmandyal.movie_explorer.domain.usecase.GetCreditsUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetMovieBannersUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetMovieDetailsUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetMovieTrailerVideoUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetRecommendedUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetReviewsUseCase
import com.codewithmandyal.movie_explorer.domain.usecase.GetSimilarUseCase
import com.codewithmandyal.movie_explorer.features.details.common.DetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {

    single<DetailsRepository> {
        DetailsRepositoryImpl(
            get()
        )
    }

    factory {
        GetMovieBannersUseCase(get())
    }

    factory {
        GetMovieDetailsUseCase(get())
    }


    factory {
        GetCreditsUseCase(get())
    }

    factory {
        GetRecommendedUseCase(get())
    }

    factory {
        GetSimilarUseCase(get())
    }



    factory {
        GetMovieTrailerVideoUseCase(get())
    }

    factory {
        GetReviewsUseCase(get())
    }

    viewModel {
        DetailsViewModel(get(), get(), get(), get(), get(), get(), get())
    }
}