package com.blu.testcase.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class TransactionDto(
    val transactionId: Long,
    val transactionTitle: String,
    val transactionDateTime: Long,
    val amount: Long,
    @DrawableRes val icon: Int,
    val transactionType: TransactionType,
): Parcelable









