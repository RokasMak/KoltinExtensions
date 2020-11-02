package com.telesoftas.kotlinextensions

import android.view.View
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

fun View.isVisible() = this.visibility == View.VISIBLE

fun Any?.isNull() = this == null

fun Int.toDate(): Date = Date(toMilliseconds())

fun Int.toMilliseconds() = this  * 1000L

fun Long.toSeconds() = (this  / 1000).toInt()

fun Double.toPrice(pattern : String = "#,###.00"): String {
    val decimalFormat = DecimalFormat(pattern)
    decimalFormat.groupingSize = 3

    return "€" + decimalFormat.format(this)
}

fun String.toDate(format: String): Date? {
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())
    return try {
        dateFormatter.parse(this)
    } catch (e: ParseException) {
        null
    }
}

val String.containsDigit: Boolean
    get() = matches(Regex(".*[0-9].*"))

val String.isAlphanumeric: Boolean
    get() = matches(Regex("[a-zA-Z0-9]*"))

fun String.isEmailValid(): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

val String.lastPathComponent: String
    get() {
        var path = this
        if (path.endsWith("/"))
            path = path.substring(0, path.length - 1)
        var index = path.lastIndexOf('/')
        if (index < 0) {
            if (path.endsWith("\\"))
                path = path.substring(0, path.length - 1)
            index = path.lastIndexOf('\\')
            if (index < 0)
                return path
        }
        return path.substring(index + 1)
    }


/**
 * Performance warning.
 * SimpleDateFormat is created every time.
 * If you use this to convert big data, create date formatter locally and reuse the instance.
 */
fun Date.toString(format: String): String {
    val dateFormatter = SimpleDateFormat(format, Locale.US)
    return dateFormatter.format(this)
}