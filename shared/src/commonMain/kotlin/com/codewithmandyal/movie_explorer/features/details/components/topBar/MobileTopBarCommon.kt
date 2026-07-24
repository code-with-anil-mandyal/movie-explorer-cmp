package com.codewithmandyal.movie_explorer.features.details.components.topBar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.codewithmandyal.movie_explorer.core.components.BackButton
import com.codewithmandyal.movie_explorer.core.ui.defaults.BackButtonDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.WindowType

@Composable
fun MobileTopBarCommon(
    onBackPress: () -> Unit
) {

    val dimens = LocalAppDimens.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimens.toolbarHeight)
            .padding(horizontal = dimens.screenPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {

        BackButton(
            circleSize = BackButtonDefaults.circleSize(WindowType.Compact),
            arrowSize = BackButtonDefaults.arrowSize(WindowType.Compact),
            onClick = onBackPress
        )
    }
}