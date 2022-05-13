package com.example.moviefun.ui.base.viewmodel

import android.content.Context
import com.example.moviefun.ui.base.BaseNavigator
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel(context: Context, navigator: BaseNavigator) {

    val context = context
    val navigator = navigator
    val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun onActivityDestroyed() {
        compositeDisposable.clear()
    }
}
