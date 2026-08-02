package com.codewithmandyal.movie_explorer.features.details.defaults.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.domain.model.Movie

@Composable
fun QuickFacts(
    movie: Movie
) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimens.screenPadding)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.FactCard(
                modifier = Modifier.weight(1f),
                title = "BUDGET",
                value = movie.budget.toString()
            )

            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.FactCard(
                modifier = Modifier.weight(1f),
                title = "REVENUE",
                value = movie.revenue.toString()
            )
        }

        SpaceVertical(dimens.cardSpacing * 2)

        Row(
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.FactCard(
                modifier = Modifier.weight(1f),
                title = "LOCATIONS",
                value = if (movie.productionCountries.isNullOrEmpty()) {
                    "N/A"
                } else {
                    movie.productionCountries.joinToString { it.name }
                }
            )

            _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.FactCard(
                modifier = Modifier.weight(1f),
                title = "PRODUCTION",
                value = if (movie.productionCompanies.isNullOrEmpty()) {
                    "N/A"
                } else {
                    movie.productionCompanies.joinToString { it.name }
                }
            )
        }
    }
}