package com.example.moviefun.ui.base

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapterBinding<X : ViewDataBinding, T : BaseViewHolderBinding<X, K>, K>(
    val context: Context,
    val list: List<K>) : RecyclerView.Adapter<BaseViewHolderBinding<X, K>>() {

    abstract fun getViewHolder(parent:ViewGroup, viewType: Int) : T

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolderBinding<X, K> {
       return getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolderBinding<X, K>, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
