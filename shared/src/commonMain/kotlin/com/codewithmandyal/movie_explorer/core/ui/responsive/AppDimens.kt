package com.codewithmandyal.movie_explorer.core.ui.responsive

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class AppDimens(

    // Spacing
    val screenPadding: Dp,
    val itemSpacing: Dp,
    val sectionSpacing: Dp,
    val cardSpacing: Dp,

    // Sizes
    val toolbarHeight: Dp,
    val logoSize: Dp,
    val profileSize: Dp,
    val searchBarWidth: Dp,
    val searchBarHeight: Dp,

    // Corners
    val cornerSmall: Dp,
    val cornerMedium: Dp,
    val cornerLarge: Dp,

    // Typography
    val titleFont: TextUnit,
    val sectionTitleFont: TextUnit,
    val bodyFont: TextUnit,
    val captionFont: TextUnit
)

val CompactDimens = AppDimens(

    screenPadding = 16.dp,
    itemSpacing = 8.dp,
    sectionSpacing = 24.dp,
    cardSpacing = 8.dp,

    toolbarHeight = 64.dp,
    logoSize = 34.dp,
    profileSize = 34.dp,
    searchBarWidth = 220.dp,
    searchBarHeight = 46.dp,

    cornerSmall = 4.dp,
    cornerMedium = 8.dp,
    cornerLarge = 16.dp,

    titleFont = 20.sp,
    sectionTitleFont = 18.sp,
    bodyFont = 14.sp,
    captionFont = 12.sp
)

val MediumDimens = AppDimens(

    screenPadding = 24.dp,
    itemSpacing = 12.dp,
    sectionSpacing = 32.dp,
    cardSpacing = 12.dp,

    toolbarHeight = 68.dp,
    logoSize = 38.dp,
    profileSize = 40.dp,
    searchBarWidth = 280.dp,
    searchBarHeight = 48.dp,

    cornerSmall = 4.dp,
    cornerMedium = 8.dp,
    cornerLarge = 16.dp,

    titleFont = 24.sp,
    sectionTitleFont = 20.sp,
    bodyFont = 15.sp,
    captionFont = 13.sp
)

val ExpandedDimens = AppDimens(

    screenPadding = 32.dp,
    itemSpacing = 16.dp,
    sectionSpacing = 40.dp,
    cardSpacing = 16.dp,

    toolbarHeight = 72.dp,
    logoSize = 42.dp,
    profileSize = 44.dp,
    searchBarWidth = 350.dp,
    searchBarHeight = 50.dp,

    cornerSmall = 4.dp,
    cornerMedium = 8.dp,
    cornerLarge = 16.dp,

    titleFont = 28.sp,
    sectionTitleFont = 22.sp,
    bodyFont = 16.sp,
    captionFont = 14.sp
)