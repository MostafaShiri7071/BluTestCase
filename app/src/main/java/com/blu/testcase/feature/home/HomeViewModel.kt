package com.blu.testcase.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.blu.testcase.appUtilities.base.BaseViewModel
import com.blu.testcase.appUtilities.base.SingleLiveEvent
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

     fun fetchAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            _allTransactionsResult.postValue(transactionRepository.fetchAllTransactions())
        }
    }
}