package com.stavro_xhardha.lek.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stavro_xhardha.lek.R
import com.stavro_xhardha.lek.ui.history.HistoryFragment
import com.stavro_xhardha.lek.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //test coment

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        openHomeFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                openHomeFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, HistoryFragment.newInstance())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, HomeFragment.newInstance())
            .commit()
    }
}
