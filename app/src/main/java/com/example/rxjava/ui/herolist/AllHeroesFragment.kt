package com.example.rxjava.ui.herolist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.rxjava.App
import com.example.rxjava.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rxjava.common.base.BaseFragment
import com.example.rxjava.databinding.FragmentTestBinding
import com.example.rxjava.util.viewModel


class AllHeroesFragment : BaseFragment(R.layout.fragment_test) {

    private val binding by viewBinding(FragmentTestBinding::bind)

    override val viewModel by viewModel { App.component.allHeroesViewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.downloadHeroes()

        viewModel.heroList.observe(viewLifecycleOwner, Observer {

        })


    }


}