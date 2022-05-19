package com.example.moviefun.ui.screen.main

import android.view.MenuItem
import com.example.moviefun.R
import com.example.moviefun.data.constants.BottomTab
import com.example.moviefun.databinding.ActivityMainBinding
import com.example.moviefun.ui.base.activity.BaseLoadDataActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : BaseLoadDataActivity<ActivityMainBinding, MainViewModel>(), MainNavigator,
    NavigationBarView.OnItemSelectedListener {

    companion object {
        const val FRAGMENT_TAG = "fragment_tag_"
    }

    lateinit var bottomNavigation: BottomNavigationView
    var currentPositionFragment = BottomTab.HOME.position

    override fun initViewModel(): MainViewModel {
        return MainViewModel(this, this)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
        super.initData()
        initBottomNavigation()
    }

    private fun initBottomNavigation(){
        bottomNavigation = binding.bottomNavigation
        bottomNavigation.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.navigation_home -> {
                return true
            }
            R.id.navigation_favorite -> {
                return true
            }
            R.id.navigation_setting -> {
                return true
            }
        }
        return false
    }
}
