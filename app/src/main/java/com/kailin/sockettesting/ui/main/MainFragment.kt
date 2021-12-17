package com.kailin.sockettesting.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kailin.sockettesting.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val mainAdapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = mainAdapter
        recyclerViewTitle.setTimeString("時間")
        recyclerViewTitle.setPriceText("價格")
        recyclerViewTitle.setCountText("數量")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.loadData()
        viewModel.aggTradesLiveData.observe(viewLifecycleOwner) {
            mainAdapter.updateData(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.stop()
    }

}