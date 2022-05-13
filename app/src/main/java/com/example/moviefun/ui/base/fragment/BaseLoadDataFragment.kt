package com.example.moviefun.ui.base.fragment

import android.app.Dialog
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ViewDataBinding
import com.example.moviefun.ui.base.viewmodel.BaseLoadDataViewModel

abstract class BaseLoadDataFragment<view: ViewDataBinding, viewModel: BaseLoadDataViewModel> : BaseFragmentBinding<view, viewModel>() {

    lateinit var loadingDialog : Dialog

    val loadingCallback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            handleLoadingChanged((sender as ObservableBoolean).get())
        }
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
        if (requireActivity().isFinishing || !isAdded) return
        loadingDialog.show()
    }

    open fun hideLoadingDialog() {
        if (requireActivity().isFinishing || !isAdded) return
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
