package com.codewithmandyal.movie_explorer.core.ui.responsive.tv

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class TvDimens(

    // Spacing
    val screenPadding: Dp,
    val itemSpacing: Dp,
    val sectionSpacing: Dp,
    val cardSpacing: Dp,

    // Top Bar
    val topBarHeight: Dp,
    val horizontalPadding: Dp,

    // Sizes
    val logoSize: Dp,
    val profileSize: Dp,
    val searchBarWidth: Dp,
    val searchBarHeight: Dp,

    // Banner
    val bannerHeight: Dp,
    val bannerContentWidth: Dp,

    // Buttons
    val buttonSpacing: Dp,
    val buttonHorizontalPadding: Dp,
    val buttonVerticalPadding: Dp,

    // Cards
    val cardWidth: Dp,
    val cardHeight: Dp,

    // Indicators
    val indicatorWidth: Dp,
    val indicatorHeight: Dp,

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

val CompactTvDimens = TvDimens(

    // Spacing
    screenPadding = 32.dp,
    itemSpacing = 12.dp,
    sectionSpacing = 32.dp,
    cardSpacing = 12.dp,

    // Top Bar
    topBarHeight = 80.dp,
    horizontalPadding = 32.dp,

    // Sizes
    logoSize = 48.dp,
    profileSize = 44.dp,
    searchBarWidth = 320.dp,
    searchBarHeight = 52.dp,

    // Banner
    bannerHeight = 500.dp,
    bannerContentWidth = 500.dp,

    // Buttons
    buttonSpacing = 16.dp,
    buttonHorizontalPadding = 22.dp,
    buttonVerticalPadding = 12.dp,

    // Cards
    cardWidth = 170.dp,
    cardHeight = 255.dp,

    // Indicators
    indicatorWidth = 28.dp,
    indicatorHeight = 6.dp,

    // Corners
    cornerSmall = 6.dp,
    cornerMedium = 12.dp,
    cornerLarge = 18.dp,

    // Typography
    titleFont = 34.sp,
    sectionTitleFont = 24.sp,
    bodyFont = 16.sp,
    captionFont = 14.sp
)

val MediumTvDimens = TvDimens(

    // Spacing
    screenPadding = 48.dp,
    itemSpacing = 16.dp,
    sectionSpacing = 40.dp,
    cardSpacing = 16.dp,

    // Top Bar
    topBarHeight = 88.dp,
    horizontalPadding = 48.dp,

    // Sizes
    logoSize = 56.dp,
    profileSize = 52.dp,
    searchBarWidth = 380.dp,
    searchBarHeight = 58.dp,

    // Banner
    bannerHeight = 620.dp,
    bannerContentWidth = 650.dp,

    // Buttons
    buttonSpacing = 20.dp,
    buttonHorizontalPadding = 28.dp,
    buttonVerticalPadding = 16.dp,

    // Cards
    cardWidth = 210.dp,
    cardHeight = 315.dp,

    // Indicators
    indicatorWidth = 36.dp,
    indicatorHeight = 8.dp,

    // Corners
    cornerSmall = 8.dp,
    cornerMedium = 14.dp,
    cornerLarge = 20.dp,

    // Typography
    titleFont = 46.sp,
    sectionTitleFont = 28.sp,
    bodyFont = 20.sp,
    captionFont = 16.sp
)

val ExpandedTvDimens = TvDimens(

    // Spacing
    screenPadding = 64.dp,
    itemSpacing = 20.dp,
    sectionSpacing = 48.dp,
    cardSpacing = 20.dp,

    // Top Bar
    topBarHeight = 96.dp,
    horizontalPadding = 64.dp,

    // Sizes
    logoSize = 64.dp,
    profileSize = 60.dp,
    searchBarWidth = 460.dp,
    searchBarHeight = 64.dp,

    // Banner
    bannerHeight = 720.dp,
    bannerContentWidth = 760.dp,

    // Buttons
    buttonSpacing = 24.dp,
    buttonHorizontalPadding = 34.dp,
    buttonVerticalPadding = 18.dp,

    // Cards
    cardWidth = 250.dp,
    cardHeight = 375.dp,

    // Indicators
    indicatorWidth = 42.dp,
    indicatorHeight = 10.dp,

    // Corners
    cornerSmall = 10.dp,
    cornerMedium = 16.dp,
    cornerLarge = 24.dp,

    // Typography
    titleFont = 54.sp,
    sectionTitleFont = 34.sp,
    bodyFont = 24.sp,
    captionFont = 18.sp
)