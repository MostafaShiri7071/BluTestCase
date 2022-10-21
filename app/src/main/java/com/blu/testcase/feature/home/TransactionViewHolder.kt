package com.blu.testcase.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.blu.testcase.R
import com.blu.testcase.appUtilities.component.PersianCalendar
import com.blu.testcase.appUtilities.extention.asCurrency
import com.blu.testcase.appUtilities.extention.getJalaliFormattedDate
import com.blu.testcase.data.TransactionDto
import com.blu.testcase.data.TransactionType
import com.blu.testcase.databinding.ItemTransactionBinding

class TransactionViewHolder(
    private val binding: ItemTransactionBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(transaction: TransactionDto) {
        binding.tvTransactionTitle.text=transaction.transactionTitle
        binding.tvTransactionAmount.text=transaction.amount.toString().asCurrency()
        binding.tvTransactionDateTime.text = transaction.transactionDateTime.getJalaliFormattedDate(
            withTime = true,
            embedLTR = true
        )

        binding.imgTransactionType.setImageResource(transaction.icon)
        binding.tvTransactionAmount.setBackgroundColor(
            if (transaction.transactionType==TransactionType.WITHDRAW)
                ContextCompat.getColor(binding.tvTransactionAmount.context,R.color.colorHighlightTint
                ) else 0
        )

    }

    companion object {
        fun create(
            parent: ViewGroup
        ): TransactionViewHolder {
            val binding = ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TransactionViewHolder(
                binding
            )
        }
    }


}