package com.blu.testcase.feature.home

import com.blu.testcase.base.BaseFragment
import com.blu.testcase.databinding.FragmentHomeBinding


/**
 * Created by Mostafa Shiri.
 */
class HomeFragment: BaseFragment<HomeViewModel, FragmentHomeBinding>(
    FragmentHomeBinding::inflate
){

    override fun configureUI() {}

    override fun configureObservers() {
        viewModel.allTransactionsResult.observe(viewLifecycleOwner) { transactions ->
            val r=transactions
        }
    }
}