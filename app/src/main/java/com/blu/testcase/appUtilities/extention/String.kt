package com.blu.testcase.appUtilities.extention

import java.util.*

fun String.asCurrency(): String {
    return this.addThousandSeparator() + " " + "ریال"
}

fun String.addThousandSeparator(): String {
    var s = this
    if (s.contains(".")) {
        s = s.substring(0, s.indexOf("."))
    }
    val f = StringBuilder()
    val temp = s.replace("[^0-9۰-۹]+".toRegex(), "")
    for (i in temp.indices) {
        f.append(temp[i])
        if ((temp.length - 1 - i) % 3 == 0 && temp.length - 1 - i != 0) {
            f.append(",")
        }
    }
    return toPersianNumber(f.toString())
}

fun toPersianNumber(englishNumbers: String): String {
    val output = StringBuilder()
    englishNumbers.toCharArray().forEach {
        val old = it.toString()
        var new = old.replace("0", "۰")
        new = new.replace("1", "۱")
        new = new.replace("2", "۲")
        new = new.replace("3", "۳")
        new = new.replace("4", "۴")
        new = new.replace("5", "۵")
        new = new.replace("6", "۶")
        new = new.replace("7", "۷")
        new = new.replace("8", "۸")
        new = new.replace("9", "۹")
        output.append(new)
    }
    return output.toString()
}
