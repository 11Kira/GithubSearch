package com.test.githubsearch.utils

import java.text.NumberFormat
import java.util.*
import kotlin.math.ln
import kotlin.math.pow

/**
 * Object containing conversion related functions.
 * @author Julius Villagracia
 */
object ConversionUtil {

    /**
     * Formats number to add comma on large values
     * @param number The number to converted
     * @return the converted value in string format
     * @see (https://stackoverflow.com/questions/41859525/how-to-go-about-formatting-1200-to-1-2k-in-android-studio)
     * @see (https://stackoverflow.com/questions/19788113/how-can-i-format-a-string-number-to-have-commas-in-android-edit-field)
     */
    fun formatLargeNumber(number: Int): String {
        return if (number < 1000) {
            NumberFormat.getNumberInstance(Locale.getDefault()).format(number)
        } else {
            val exp = (ln(number.toDouble()) / ln(1000.0)).toInt()
            return String.format("%.1f%c", number / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
        }
    }
}