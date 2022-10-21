package com.blu.testcase.appUtilities.extention

import com.blu.testcase.appUtilities.component.DateUtils
import java.text.SimpleDateFormat
import java.util.*

fun Long.getJalaliFormattedDate(withTime: Boolean, embedLTR: Boolean): String? {
    return Date(this).getJalaliFormattedDate(withTime, embedLTR)
}

fun Date.getJalaliFormattedDate(withTime: Boolean, embedLTR: Boolean): String? {
    val format = if (withTime) "yyyy/MM/dd - HH:mm" else "yyyy/MM/dd"
    return this.getJalaliFormattedDate(format, embedLTR)
}

fun Long.getJalaliFormattedDate(format: String?, embedLTR: Boolean): String? {
    return Date(this).getJalaliFormattedDate(format, embedLTR)
}

fun Date.getJalaliFormattedDate(format: String?, embedLTR: Boolean): String? {
    val cal = Calendar.getInstance()
    cal.time = this
    val jalaliDate: String = if (embedLTR)
        DateUtils.getLocaleDate(DateUtils.FARSI_LOCALE, this, format, true)
    else
        DateUtils.getLocaleDate(DateUtils.ENGLISH_LOCALE, this, format, true)
    return if (embedLTR) {
        embedLTR(jalaliDate)
    } else {
        jalaliDate
    }
}

fun embedLTR(text: String): String {
    return if (text.isEmpty()) {
        ""
    } else '\u202A'.toString() + text + '\u202A'
}

inline fun date(
    timeInMillis: Long = System.currentTimeMillis(),
    block: SimpleDate.() -> Unit = {}
): SimpleDate {
    val dateDsl = SimpleDate()
    dateDsl.timeInMillis = timeInMillis
    block(dateDsl)
    return dateDsl
}


class SimpleDate {

    private val calendar: Calendar = Calendar.getInstance()

    var timeInMillis = System.currentTimeMillis()
        get() = calendar.timeInMillis
        set(value) {
            calendar.timeInMillis = value
            field = value
        }

    var date = Date()
        get() = calendar.time
        set(value) {
            calendar.time = value
            field = value
        }

    fun format(pattern: String, locale: Locale = Locale.US): String {
        return SimpleDateFormat(pattern, locale).format(date)
    }

    val nextDay: SimpleDate get() = addDay(1)
    val nextWeek: SimpleDate get() = addDay(7)
    val nextYear: SimpleDate get() = addYear(1)
    val nextNextMonth: SimpleDate get() = addMonth(1)

    fun addDay(day: Int): SimpleDate {
        this.day += day
        return this
    }

    fun addYear(year: Int): SimpleDate {
        this.year += year
        return this
    }

    fun addMonth(month: Int): SimpleDate {
        this.month += month
        return this
    }

    fun addHour(hour: Int): SimpleDate {
        this.hour += hour
        return this
    }

    fun addMinute(minute: Int): SimpleDate {
        this.minute += minute
        return this
    }

    fun addSecond(second: Int): SimpleDate {
        this.second += second
        return this
    }

    fun addMillisecond(millisecond: Int): SimpleDate {
        this.millisecond += millisecond
        return this
    }

    var year = calendar.get(Calendar.YEAR)
        set(value) {
            calendar.set(Calendar.YEAR, value); field = value
        }
    var day = calendar.get(Calendar.DAY_OF_MONTH)
        set(value) {
            calendar.set(Calendar.DAY_OF_MONTH, value); field = value
        }
    var dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        set(value) {
            calendar.set(Calendar.DAY_OF_WEEK, value); field = value
        }
    var month = calendar.get(Calendar.MONTH) + 1
        set(value) {
            calendar.set(Calendar.MONTH, value - 1); field = value
        }
    var hour = calendar.get(Calendar.HOUR)
        set(value) {
            calendar.set(Calendar.HOUR, value); field = value
        }
    var minute = calendar.get(Calendar.MINUTE)
        set(value) {
            calendar.set(Calendar.MINUTE, value); field = value
        }
    var second = calendar.get(Calendar.SECOND)
        set(value) {
            calendar.set(Calendar.SECOND, value); field = value
        }
    var millisecond = calendar.get(Calendar.MILLISECOND)
        set(value) {
            calendar.set(Calendar.MILLISECOND, value); field = value
        }
}