package com.example.moviefun.ui.base.activity

import android.app.Dialog
import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ViewDataBinding
import com.example.moviefun.ui.base.viewmodel.BaseLoadDataViewModel

abstract class BaseLoadDataActivity<view : ViewDataBinding, viewModel : BaseLoadDataViewModel> :
    BaseActivityBinding<view, viewModel>() {

    lateinit var loadingDialog : Dialog

    val loadingCallback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            handleLoadingChanged((sender as ObservableBoolean).get())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getLayoutId())
    }

    abstract fun initViewModel(): viewModel

    override fun initData() {
        initViewModel()
        viewModel.isLoadingData.addOnPropertyChangedCallback(loadingCallback)
    }

    override fun onDestroy() {
        viewModel.isLoadingData.removeOnPropertyChangedCallback(loadingCallback)
        super.onDestroy()
    }

    open fun showLoadingDialog() {
        if (isFinishing) return
        loadingDialog.show()
    }

    open fun hideLoadingDialog() {
        if (isFinishing) return
        loadingDialog.dismiss()
    }

    open fun handleLoadingChanged(isLoading: Boolean) {
        if (isLoading) {
            showLoadingDialog()
        } else {
            hideLoadingDialog()
        }
    }
}
