package com.codewithmandyal.movie_explorer.features.details.defaults.components.review

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.domain.model.Review

@Composable
fun ReviewScreen(
    reviews: List<Review>
) {

    val dimens = LocalAppDimens.current

    var selectedReview by remember {
        mutableStateOf<Review?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF363535))
            .padding(vertical = dimens.itemSpacing * 2)
    ) {

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = dimens.screenPadding
            ),
            horizontalArrangement = Arrangement.spacedBy(
                dimens.cardSpacing
            )
        ) {

            items(reviews) { review ->

                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.ReviewCard(
                    review = review,
                    onReadMore = {
                        selectedReview = it
                    }
                )
            }
        }
    }

    selectedReview?.let {

        _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.ReviewBottomSheet(
            review = it,
            onDismiss = {
                selectedReview = null
            }
        )
    }
}