package com.example.moviefun.ui.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.moviefun.ui.base.BaseNavigator
import com.example.moviefun.ui.base.viewmodel.BaseViewModel

abstract class BaseFragmentBinding<view: ViewDataBinding, viewModel: BaseViewModel>: BaseFragment() {

    lateinit var binding: view
    lateinit var viewModel: viewModel
    lateinit var navigator: BaseNavigator

    abstract fun getLayoutId(): Int
    abstract fun initData()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseNavigator) {
            navigator = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.root.isClickable = true
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onActivityDestroyed()
    }
}
