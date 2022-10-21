package com.blu.testcase.appUtilities.base.koinDi
import com.blu.testcase.data.TransactionRepository
import com.blu.testcase.data.TransactionRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TransactionRepository> {
        TransactionRepositoryImpl()
    }
}
