package com.blu.testcase.appUtilities.base.koinDi


import com.blu.testcase.feature.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {HomeViewModel(get())}
}


