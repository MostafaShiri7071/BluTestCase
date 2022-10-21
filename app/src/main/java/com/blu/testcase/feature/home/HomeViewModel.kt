package com.blu.testcase.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.blu.testcase.base.BaseViewModel
import com.blu.testcase.base.SingleLiveEvent
import com.blu.testcase.data.TransactionDto
import com.blu.testcase.data.TransactionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Mostafa Shiri.
 */

class HomeViewModel (
    private val transactionRepository: TransactionRepository
) : BaseViewModel(){

    private var _allTransactionsResult: SingleLiveEvent<List<TransactionDto>> = SingleLiveEvent()
    var allTransactionsResult: LiveData<List<TransactionDto>> = _allTransactionsResult

    init {
        fetchAllTransaction()
    }

    private fun fetchAllTransaction() {
        viewModelScope.launch(Dispatchers.IO) {
            _allTransactionsResult.postValue(transactionRepository.fetchAllTransactions())
        }
    }
}