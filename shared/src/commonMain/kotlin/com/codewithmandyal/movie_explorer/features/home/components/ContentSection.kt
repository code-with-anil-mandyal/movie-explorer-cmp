package com.codewithmandyal.movie_explorer.features.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.utils.MediaType
import com.codewithmandyal.movie_explorer.domain.model.Movie

@Composable
fun ContentSection(
    title: String,
    movieList: List<Movie>,
    titleSize: TextUnit = LocalAppDimens.current.sectionTitleFont,
    viewAllSize: TextUnit = LocalAppDimens.current.bodyFont,
    onDetailsScreen: (id: Int) -> Unit
) {

    val dimens = LocalAppDimens.current

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        HomeTitles(
            title,
            titleSize,
            viewAllSize
        )

        SpaceVertical(dimens.sectionSpacing / 2)

        ContentCards(movieList, onDetailsScreen = {
            onDetailsScreen(it)
        })
    }
}