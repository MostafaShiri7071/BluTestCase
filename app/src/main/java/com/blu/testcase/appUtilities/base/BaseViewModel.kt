package com.blu.testcase.appUtilities.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    var showProgress: SingleLiveEvent<Boolean?> =
        SingleLiveEvent()
    var responseError: SingleLiveEvent<Boolean> =
        SingleLiveEvent()

    protected fun showProgress(showProgress: Boolean) {
        this.showProgress.postValue(showProgress)
    }

}