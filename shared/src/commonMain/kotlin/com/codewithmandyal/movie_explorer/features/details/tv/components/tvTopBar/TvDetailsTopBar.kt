package com.codewithmandyal.movie_explorer.features.details.tv.components.tvTopBar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.BackButton
import com.codewithmandyal.movie_explorer.core.components.SpacerHorizontal
import com.codewithmandyal.movie_explorer.core.ui.defaults.tv.TvBackButtonDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.tv.LocalTvWindowType

@Composable
fun TvDetailsTopBar(
    elevated: Boolean,
    onBackPress: () -> Unit,
    title: String? = null,
    showSearchBar: Boolean = false,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    focusRequester: FocusRequester,
    downRequester: FocusRequester
){

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val dimens = LocalTvDimens.current
    val windowType = LocalTvWindowType.current



    val backgroundColor by animateColorAsState(
        targetValue = if (elevated) {
            Color(0xFF151515).copy(alpha = 0.95f)
        } else {
            Color(0xFF151515).copy(alpha = 0.75f)
        },
        label = "DetailsTopBarBackground"
    )

    val elevation by animateDpAsState(
        targetValue = if (elevated) 6.dp else 0.dp,
        label = "DetailsTopBarElevation"
    )

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = backgroundColor,
        tonalElevation = elevation,
        shadowElevation = elevation
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.topBarHeight)
                .padding(horizontal = dimens.screenPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {

            BackButton(
                circleSize = TvBackButtonDefaults.circleSize(windowType),
                arrowSize = TvBackButtonDefaults.arrowSize(windowType),
                onClick = {
                    println("BackButton onBackPress")
                    onBackPress()

                },
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .focusProperties {
                        down = downRequester
                    }
            )

            SpacerHorizontal(dimens.itemSpacing)

            if (showSearchBar) {

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    placeholder = {
                        Text("Search movies...")
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {

                        if (searchQuery.isNotEmpty()) {

                            IconButton(
                                onClick = {
                                    onSearchQueryChange("")
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    tint = Color.LightGray,
                                    contentDescription = "Clear Search"
                                )
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    ),
                    shape = RoundedCornerShape(50),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF252525),
                        unfocusedContainerColor = Color(0xFF252525),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedPlaceholderColor = Color.Gray,
                        unfocusedPlaceholderColor = Color.Gray
                    )
                )

            } else {

                Text(
                    text = title.orEmpty(),
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = dimens.sectionTitleFont
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                actions()
            }
        }
    }

}