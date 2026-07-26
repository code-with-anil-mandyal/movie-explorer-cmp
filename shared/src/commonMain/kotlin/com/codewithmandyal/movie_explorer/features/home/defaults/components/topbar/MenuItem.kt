package com.codewithmandyal.movie_explorer.features.home.defaults.components.topbar

data class MenuItem(
    val title: String,
    val selected: Boolean
)

val menus = listOf(
    MenuItem("Home", true),
    MenuItem("Movies", false),
    MenuItem("TV Shows", false),
    MenuItem("My List", false)
)
