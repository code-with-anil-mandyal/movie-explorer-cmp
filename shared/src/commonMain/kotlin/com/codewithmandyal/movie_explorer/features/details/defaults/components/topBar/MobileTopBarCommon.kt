package com.codewithmandyal.movie_explorer.features.details.defaults.components.topBar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.core.components.BackButton
import com.codewithmandyal.movie_explorer.core.ui.defaults.BackButtonDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalAppDimens
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.WindowType

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