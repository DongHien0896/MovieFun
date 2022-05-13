package com.example.moviefun.ui.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.moviefun.ui.base.viewmodel.BaseViewModel

abstract class BaseActivityBinding<view: ViewDataBinding, viewModel: BaseViewModel>: BaseActivity() {

    lateinit var binding: view
    lateinit var viewModel: viewModel

    abstract fun getLayoutId(): Int
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onActivityDestroyed()
    }
}
