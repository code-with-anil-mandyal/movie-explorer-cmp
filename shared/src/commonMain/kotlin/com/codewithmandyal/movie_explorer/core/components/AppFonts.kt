package com.codewithmandyal.movie_explorer.core.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import movieexplorer.shared.generated.resources.Res
import movieexplorer.shared.generated.resources.bebas_neue
import movieexplorer.shared.generated.resources.montserrat_medium
import movieexplorer.shared.generated.resources.montserrat_semibold
import org.jetbrains.compose.resources.Font

object AppFonts {

    @Composable
    fun bebas(): FontFamily {
        val font = Font(Res.font.bebas_neue, FontWeight.Normal)
        return remember(font) { FontFamily(font) }
    }

    @Composable
    fun montserratMedium(): FontFamily {
        val font = Font(Res.font.montserrat_medium, FontWeight.Medium)
        return remember(font) { FontFamily(font) }
    }

    @Composable
    fun montserratSemiBold(): FontFamily {
        val font = Font(Res.font.montserrat_semibold, FontWeight.SemiBold)
        return remember(font) { FontFamily(font) }
    }
}