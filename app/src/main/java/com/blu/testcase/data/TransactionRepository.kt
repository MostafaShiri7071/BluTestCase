package com.blu.testcase.data

interface TransactionRepository {

    suspend fun fetchAllTransactions(): ArrayList<TransactionDto>

}

class TransactionRepositoryImpl() :TransactionRepository {
    override suspend fun fetchAllTransactions(): ArrayList<TransactionDto> {
        return Transactions.generatingFakeData()
    }

}