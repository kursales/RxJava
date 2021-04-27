package com.example.rxjava.ui.herolist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjava.App
import com.example.rxjava.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rxjava.common.base.BaseFragment
import com.example.rxjava.databinding.FragmentTestBinding
import com.example.rxjava.ui.herolist.adapter.HeroAdapter
import com.example.rxjava.util.mapToHeroModelList
import com.example.rxjava.util.toArrayList
import com.example.rxjava.util.viewModel
import javax.inject.Inject


class AllHeroesFragment : BaseFragment(R.layout.fragment_test) {

    private val binding by viewBinding(FragmentTestBinding::bind)
    override val viewModel by viewModel { App.component.allHeroesViewModel }
    lateinit var recView:RecyclerView
    lateinit var heroAdapter: HeroAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        initRecycler()
        viewModel.onStarted()
//        viewModel.heroList.observe(viewLifecycleOwner, Observer {
//        heroAdapter.changeData(it.toArrayList())
//        })
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if(it){
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE
                initRecycler()
                heroAdapter.changeData(viewModel.heroList.value!!.mapToHeroModelList().toArrayList())
            }
        })

    }


    private fun initRecycler(){
        heroAdapter = HeroAdapter()
        recView = binding.allHeroesRecycler
        recView.layoutManager = LinearLayoutManager(requireContext())
        recView.adapter = heroAdapter

    }


}