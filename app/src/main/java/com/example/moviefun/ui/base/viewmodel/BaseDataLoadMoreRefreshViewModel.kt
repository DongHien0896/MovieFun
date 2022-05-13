package com.example.moviefun.ui.base.viewmodel

import android.content.Context
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.moviefun.data.constants.Constants
import com.example.moviefun.data.remote.response.BaseListResponse
import com.example.moviefun.ui.base.BaseNavigator
import com.example.moviefun.ui.widgets.EndlessRecyclerOnScrollListener

abstract class BaseDataLoadMoreRefreshViewModel<Item>(
    context: Context,
    baseNavigator: BaseNavigator
) : BaseLoadDataViewModel(context, baseNavigator) {

    val isRefreshing = ObservableBoolean()
    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        if (isLoadingData.get() || isRefreshing.get()) return@OnRefreshListener
        isRefreshing.set(true)
        refreshData()
    }

    val isDataLoadMore = ObservableBoolean()
    var currentPage: Int = 0
    var isLastPage: Boolean = false
    val onScrollListener = object : EndlessRecyclerOnScrollListener(
        getLoadMoreThreshold()) {
        override fun onLoadMore() {
            if (isLoadingData.get() || isRefreshing.get() || isDataLoadMore.get() || isLastPage) return
            isDataLoadMore.set(true)
            loadMore()
        }
    }

    val listItem = ObservableArrayList<Item>()

    abstract fun loadData(page: Int)

    fun refreshData() {
        loadData(1)
    }

    fun loadMore() {
        loadData(currentPage + 1)
    }

    fun getLoadMoreThreshold() = Constants.DEFAULT_NUM_VISIBLE_THRESHOLD

    fun getNumberItemPerPage() = Constants.DEFAULT_ITEM_PER_PAGE

    fun resetLoadMore() {
        listItem.clear()
        onScrollListener.resetOnLoadMore()
        isLastPage = false
    }

    fun onLoadSuccess(baseListResponse: BaseListResponse<Item>) {
        isLastPage = baseListResponse.page == baseListResponse.totalPages
        isLoadingData.set(false)
        isRefreshing.set(false)
        isDataLoadMore.set(false)
    }

    override fun onLoadFail() {
        super.onLoadFail()
        isRefreshing.set(false)
        isDataLoadMore.set(false)
    }
}
