package com.codewithmandyal.movie_explorer.core.utils

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

fun String?.toYear(): String {
    if (this.isNullOrBlank()) return "--"

    return try {
        LocalDate.parse(this).year.toString()
    } catch (_: Exception) {
        "--"
    }
}

fun Long.toMoneyFormat(): String {
    if (this <= 0) return "N/A"

    return when {
        this >= 1_000_000_000 -> {
            val value = (this / 100_000_000.0).toInt() / 10.0
            "$$value Billion"
        }

        this >= 1_000_000 -> {
            val value = (this / 100_000.0).toInt() / 10.0
            "$$value Million"
        }

        else -> "$$this"
    }
}

@OptIn(ExperimentalTime::class)
fun String.toReviewDate(): String {
    return try {
        val createdDate = Instant.parse(this)
        val now = Clock.System.now()

        val diff = now - createdDate
        val days = diff.inWholeDays

        when {
            days == 0L -> "Today"
            days == 1L -> "1 day ago"
            days in 2..6 -> "$days days ago"
            days in 7..13 -> "1 week ago"
            else -> {
                val localDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault()).date
                val month = when (localDate.monthNumber) {
                    1 -> "Jan"
                    2 -> "Feb"
                    3 -> "Mar"
                    4 -> "Apr"
                    5 -> "May"
                    6 -> "Jun"
                    7 -> "Jul"
                    8 -> "Aug"
                    9 -> "Sep"
                    10 -> "Oct"
                    11 -> "Nov"
                    12 -> "Dec"
                    else -> ""
                }

                "${localDate.dayOfMonth} $month ${localDate.year}"
            }
        }
    } catch (e: Exception) {
        this
    }
}

@OptIn(ExperimentalTime::class)
fun today(): String {
    return Clock.System.todayIn(TimeZone.currentSystemDefault()).toString()
}

@OptIn(ExperimentalTime::class)
fun thirtyDaysAgo(): String {
    return Clock.System
        .todayIn(TimeZone.currentSystemDefault())
        .minus(30, DateTimeUnit.DAY)
        .toString()
}