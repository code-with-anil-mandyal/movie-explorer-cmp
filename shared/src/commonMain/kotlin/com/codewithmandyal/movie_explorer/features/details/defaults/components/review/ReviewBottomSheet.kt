package com.codewithmandyal.movie_explorer.features.details.defaults.components.review

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codewithmandyal.movie_explorer.core.components.SpaceVertical
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.domain.model.Review

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewBottomSheet(
    review: Review,
    onDismiss: () -> Unit
) {

    val dimens = LocalAppDimens.current

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = Color(0xFF1B1B1B),
        dragHandle = {
            BottomSheetDefaults.DragHandle(
                color = Color.Gray
            )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .padding(dimens.screenPadding)
                .navigationBarsPadding()
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.Avatar(
                    review.avatarPath,
                    review.name
                )

                SpacerHorizontal(dimens.itemSpacing)

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = review.name.orEmpty(),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = dimens.sectionTitleFont,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )

                    Text(
                        text = review.date.orEmpty(),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = dimens.bodyFont,
                            color = Color.LightGray
                        )
                    )
                }

                _root_ide_package_.com.codewithmandyal.movie_explorer.features.details.defaults.components.review.RatingBadge(
                    review.rating ?: 0.0
                )
            }

            SpaceVertical(dimens.sectionSpacing / 2)

            Box(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {

                Text(
                    text = review.content.orEmpty(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = dimens.bodyFont,
                        color = Color(0xFFECCACA),
                        fontStyle = FontStyle.Italic,
                        lineHeight = 24.sp
                    )
                )
            }
        }
    }
}