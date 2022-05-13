package com.example.moviefun.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.moviefun.ui.widgets.PullRefreshRecyclerView

class BindingUtils {

    companion object {

        @BindingAdapter("recyclerAdapter")
        fun setRecyclerAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
            view.setHasFixedSize(true)
            view.adapter = adapter
        }

        @BindingAdapter("onScrollListener")
        fun setScrollListener(
            view: RecyclerView,
            listener: RecyclerView.OnScrollListener?
        ) {
            if (listener != null) view.addOnScrollListener(listener)
        }

        @BindingAdapter("layoutManager")
        fun setLayoutManager(
            view: RecyclerView,
            layoutManager: RecyclerView.LayoutManager
        ) {
            view.layoutManager = layoutManager
        }

        @BindingAdapter("recyclerAdapter")
        fun setPTRRecyclerAdapter(
            view: PullRefreshRecyclerView,
            adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
        ) {
            view.adapter.set(adapter)
        }

        @BindingAdapter("layoutManager")
        fun setPTRLayoutManager(
            view: PullRefreshRecyclerView,
            layoutManager: RecyclerView.LayoutManager
        ) {
            view.layoutManager.set(layoutManager)
        }

        @BindingAdapter("onScrollListener")
        fun setPTRScrollListener(
            view: PullRefreshRecyclerView,
            listener: RecyclerView.OnScrollListener
        ) {
            view.onScrollListener.set(listener)
        }

        @BindingAdapter("refreshListener")
        fun setPTRRefreshListener(
            view: PullRefreshRecyclerView,
            listener: SwipeRefreshLayout.OnRefreshListener
        ) {
            view.onRefreshListener.set(listener)
        }

        @BindingAdapter("refreshing")
        fun setPTRRefreshing(
            view: PullRefreshRecyclerView,
            isRefreshing: Boolean
        ) {
            view.isRefreshing.set(isRefreshing)
        }
    }
}
