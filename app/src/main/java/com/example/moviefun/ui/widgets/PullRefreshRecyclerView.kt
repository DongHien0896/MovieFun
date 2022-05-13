package com.example.moviefun.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.moviefun.R
import com.example.moviefun.databinding.LayoutPtrRecyclerViewBinding

class PullRefreshRecyclerView(context: Context, attributeSet: AttributeSet) : FrameLayout(
    context,
    attributeSet
) {

    val layoutManager = ObservableField<RecyclerView.LayoutManager>()
    val adapter = ObservableField<RecyclerView.Adapter<RecyclerView.ViewHolder>>()
    val onScrollListener = ObservableField<RecyclerView.OnScrollListener>()
    val isRefreshing = ObservableBoolean()
    val onRefreshListener = ObservableField<SwipeRefreshLayout.OnRefreshListener>()
    val binding: LayoutPtrRecyclerViewBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.layout_ptr_recycler_view, this, true
    )

    init {
        binding.view = this
    }

    fun setRefreshing(isRefreshing: Boolean) {
        this.isRefreshing.set(isRefreshing)
    }

    fun scrollToPosition(position: Int) {
        binding.ptrRecyclerView.scrollToPosition(position)
    }

    fun smoothScrollToPosition(position: Int) {
        binding.ptrRecyclerView.smoothScrollToPosition(position)
    }

    fun turnOnRefresh() {
        binding.swipeLayout.isEnabled = true
    }

    fun turnOffRefresh() {
        binding.swipeLayout.isEnabled = false
    }
}
