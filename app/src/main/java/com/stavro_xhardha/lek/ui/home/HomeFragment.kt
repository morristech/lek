package com.stavro_xhardha.lek.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.stavro_xhardha.lek.R
import javax.inject.Inject

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        performDependencyInjection()
        viewModel = ViewModelProviders.of(this, homeViewModelFactory).get(HomeViewModel::class.java)
    }

    private fun performDependencyInjection() {
        DaggerHomeComponent.builder().build().inject(this)
    }

}
