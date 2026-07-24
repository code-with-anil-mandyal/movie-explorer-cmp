package com.codewithmandyal.movie_explorer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform