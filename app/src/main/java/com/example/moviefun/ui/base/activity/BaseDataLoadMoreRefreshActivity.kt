package com.example.moviefun.ui.base.activity

import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.moviefun.R
import com.example.moviefun.ui.base.viewmodel.BaseDataLoadMoreRefreshViewModel
import com.example.moviefun.ui.widgets.OnListChangedListener

abstract class BaseDataLoadMoreRefreshActivity<View : ViewDataBinding, ViewModel : BaseDataLoadMoreRefreshViewModel<Item>, Item> :
    BaseLoadDataActivity<View, ViewModel>() {

    lateinit var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

    override fun getLayoutId(): Int {
        return R.layout.activity_base_loadmore_refresh
    }

    override fun initData() {
        super.initData()
        viewModel.listItem.addOnListChangedCallback(
            OnListChangedListener<ObservableList<Item>, Item>(adapter)
        )
        initRecyclerView()
    }

    abstract fun initRecyclerView()

    override fun handleLoadingChanged(isLoading: Boolean) {
        // implement if need
    }
}
