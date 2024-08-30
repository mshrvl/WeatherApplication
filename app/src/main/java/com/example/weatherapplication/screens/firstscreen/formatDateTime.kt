package com.example.weatherapplication.screens.firstscreen

import java.text.SimpleDateFormat
import java.util.Date


fun formatTime(dateTimeString: String): Date? {
    try {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        return sdf.parse(dateTimeString)
    } catch (e: Exception) {
        return null
    }
}

fun formateDate(dateTimeString: String): Date? {
    val stf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
    return stf.parse(dateTimeString)
}

fun formateDateToMonthAndDay(date: Date): String? {
    val stf = SimpleDateFormat("MM-dd HH:mm")
    return stf.format(date)
}

fun Date.getFormattedTime(): String {
    val sdf = SimpleDateFormat("HH:mm")
    return sdf.format(this)
}

fun Date.getFormattedDate(): String {
    val stf = SimpleDateFormat("MM:dd".reversed())
    return stf.format(this)
}

fun areDatesSameDay(date1: Date, date2: Date): Boolean {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    return sdf.format(date1) == sdf.format(date2)
}