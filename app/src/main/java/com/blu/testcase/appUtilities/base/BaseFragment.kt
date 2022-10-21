package com.blu.testcase.appUtilities.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.blu.testcase.R
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

open class BaseFragment<M : BaseViewModel, T : ViewBinding>(
    private val fragmentInflate: FragmentInflate<T>
) : Fragment() {

    val viewModel: M by lazy {
            getViewModel(viewModelClass())
    }
    private var _binding: T? = null
    private lateinit var baseLayout: View
    private lateinit var root: View
    val binding: T? get() = _binding

    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<M> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<M>).kotlin
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = fragmentInflate.invoke(inflater, container, false)
        baseLayout = inflater.inflate(R.layout.fragment_base_layout, container, false)
        return baseLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root = view.findViewById(R.id.root)
        view.findViewById<LinearLayout>(R.id.layoutMain).addView(
            binding?.root,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
        configureUI()
        configureObservers()
    }

    open fun configureUI() {}
    open fun configureObservers() {}

    override fun onStart() {
        super.onStart()
        viewModel.showProgress.observe(this) {
            it?.let {
                handleProgress(it)
            }
        }
        viewModel.responseError.observe(this) {
            handleFailure(it)
        }
    }

    fun handleProgress(showProgress: Boolean) {
        if (showProgress) {
            showProgress()
        } else {
            hideProgress()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun onBackPress(f: () -> Unit) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                f.invoke()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun showProgress() {
        baseLayout.findViewById<View>(R.id.base_loading_spinner).visibility =
            View.VISIBLE
    }

    private fun hideProgress() {
        baseLayout.findViewById<View>(R.id.base_loading_spinner).visibility =
            View.GONE
    }

    protected open fun handleFailure(failure: Boolean) {
    }

}



