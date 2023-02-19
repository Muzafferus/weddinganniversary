package com.muzafferus.weddinganniversary.util

import androidx.compose.ui.graphics.Color
import java.text.SimpleDateFormat
import java.util.*

object Util {
    fun parseDate(coupleWeddingDate: String): String {
        val toDate =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(coupleWeddingDate)
        return toDate?.let { SimpleDateFormat("yyyy MMM dd", Locale.ENGLISH).format(it) } ?: "2023"
    }

    fun getColor(coupleWeddingDate: String): Color {
        return when (getYears(coupleWeddingDate)) {
            in 5..9 -> Color.Gray
            in 10..100 -> Color.Yellow
            else -> Color.White
        }
    }

    private fun getYears(coupleWeddingDate: String): Int {
        return getDays(coupleWeddingDate) / 365
    }

    fun isHasTwoWeeks(coupleWeddingDate: String): Boolean {
        return (getDaysExs(coupleWeddingDate) % 365) in 0..14
    }

    private fun getDays(coupleWeddingDate: String): Int {
        val toDate =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(coupleWeddingDate)

        val diff: Long = Date().time - toDate.time
        return ((diff / 3600000) / 24).toInt()
    }

    fun getDaysExs(coupleWeddingDate: String): Int {
        val toDate =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(coupleWeddingDate)

        return (((((toDate.time / 3600000) / 24).toInt()) % 365) - ((((Date().time / 3600000) / 24).toInt()) % 365))
    }
}