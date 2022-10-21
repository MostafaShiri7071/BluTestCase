package com.blu.testcase.feature.home

import com.blu.testcase.appUtilities.base.BaseFragment
import com.blu.testcase.databinding.FragmentHomeBinding


/**
 * Created by Mostafa Shiri.
 */
class HomeFragment: BaseFragment<HomeViewModel, FragmentHomeBinding>(
    FragmentHomeBinding::inflate
){

    private val transactionAdapter: TransactionAdapter by lazy {
        TransactionAdapter()
    }

    override fun configureUI() {
        configureTransactionList()
        viewModel.fetchAllTransactions()
    }

    override fun configureObservers() {
        viewModel.allTransactionsResult.observe(viewLifecycleOwner){transactions ->
            transactionAdapter.submitList(transactions)
        }
    }

    private fun configureTransactionList() {
        binding?.rvTransaction?.adapter = transactionAdapter
    }
}