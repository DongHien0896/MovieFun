package com.example.moviefun.ui.base.viewmodel

import android.content.Context
import androidx.databinding.ObservableBoolean
import com.example.moviefun.ui.base.BaseNavigator

abstract class BaseLoadDataViewModel(context: Context, navigator: BaseNavigator) :
    BaseViewModel(context, navigator) {

    val isLoadingData = ObservableBoolean()

    open fun onLoadFail() {
        isLoadingData.set(false)
    }
}
