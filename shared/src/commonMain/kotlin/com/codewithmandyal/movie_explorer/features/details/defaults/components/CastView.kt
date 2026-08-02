package com.codewithmandyal.movie_explorer.features.details.defaults.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.domain.model.CastAndCrew

@Composable
fun CastView(
    casts: List<CastAndCrew>
) {

    val dimens = LocalAppDimens.current

    Column {

        _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.DetailTitles(
            "CAST"
        )

        SpaceVertical(dimens.itemSpacing)

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            items(casts) { cast ->

                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.CreditItem(
                    cast
                )
            }
        }
    }
}

