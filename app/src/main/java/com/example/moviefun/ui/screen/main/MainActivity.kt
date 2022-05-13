package com.example.moviefun.ui.screen.main

import android.os.Bundle
import com.example.moviefun.R
import com.example.moviefun.databinding.ActivityMainBinding
import com.example.moviefun.ui.base.activity.BaseLoadDataActivity

class MainActivity : BaseLoadDataActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    override fun initViewModel(): MainViewModel {
        return MainViewModel(this, this)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
