package com.blu.testcase.feature.home

import android.view.ViewTreeObserver
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.blu.testcase.appUtilities.base.BaseFragment
import com.blu.testcase.appUtilities.component.ScreenConfigs
import com.blu.testcase.appUtilities.extention.asCurrency
import com.blu.testcase.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


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
        improveScroll()
        binding?.header?.tvBalance?.text=("12345678").asCurrency()
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

    private fun improveScroll(){
        binding.let {
            val behavior = BottomSheetBehavior.from(binding!!.bottomSheet)
            val headerLayout = binding?.header
            headerLayout?.headerRoot?.viewTreeObserver?.addOnGlobalLayoutListener(object :
                ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    headerLayout.headerRoot.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                    val screenHeight = ScreenConfigs.getScreenHeight(requireActivity())
                    val heightSize =
                        headerLayout.headerRoot.height + ScreenConfigs.dp(40f) + (headerLayout.headerRoot.layoutParams as CoordinatorLayout.LayoutParams).topMargin
                    behavior.peekHeight = screenHeight - heightSize
                }
            })
        }
    }
}