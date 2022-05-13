package com.example.moviefun.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolderBinding<T : ViewDataBinding, K>(val binding: T) :
    RecyclerView.ViewHolder(binding.root) {

        abstract fun bindData(item: K)

        interface OnItemClickListener<K>{
            fun onItemClick(position: Int, data: K)
        }
}
