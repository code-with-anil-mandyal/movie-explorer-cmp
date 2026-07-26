package com.codewithmandyal.movie_explorer.features.splash.defaults.components



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codewithmandyal.movie_explorer.core.ui.defaults.SplashDefaults
import com.codewithmandyal.movie_explorer.core.ui.responsive.defaults.LocalWindowType
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.movie_explorer_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashLogo(
    modifier: Modifier = Modifier
) {
    val windowType = LocalWindowType.current

    Image(
        painter = painterResource(Res.drawable.movie_explorer_logo),
        contentDescription = "Movie Explorer Logo",
        modifier = modifier
            .size(
            SplashDefaults.logoSize(windowType)
        )
    )
}