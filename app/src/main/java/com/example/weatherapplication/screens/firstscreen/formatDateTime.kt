package com.example.weatherapplication.screens.firstscreen

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date


fun formatTime(dateTimeString: String): Date? {
    try {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        return sdf.parse(dateTimeString)
    } catch (e: Exception) {
        return null
    }
}

fun Date.getFormattedTime(): String {
    val sdf = SimpleDateFormat("HH:mm")
    return sdf.format(this)
}