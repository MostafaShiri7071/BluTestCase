package com.blu.testcase.feature.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.blu.testcase.data.TransactionDto

class TransactionAdapter() :
    ListAdapter<TransactionDto,TransactionViewHolder>(TRANSACTION_COMPARATOR) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): TransactionViewHolder {
        return TransactionViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }


    companion object {
        private val TRANSACTION_COMPARATOR = object : DiffUtil.ItemCallback<TransactionDto>() {
            override fun areItemsTheSame(
                oldItem: TransactionDto,
                newItem: TransactionDto
            ): Boolean = oldItem.transactionId == newItem.transactionId

            override fun areContentsTheSame(
                oldItem: TransactionDto,
                newItem: TransactionDto
            ): Boolean = oldItem == newItem
        }


    }



}