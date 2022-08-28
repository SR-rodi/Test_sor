package com.example.core.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.flow.StateFlow

abstract class BaseFragment<B : ViewBinding>(layoutId: Int? = null) : Fragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    private val viewModel by viewModels<BaseViewModel>()

    protected abstract fun initBinding(inflater: LayoutInflater): B?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initBinding(inflater)
        val animationOne =
            TransitionInflater
                .from(requireContext())
                .inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animationOne
        return binding.root
    }

    fun newNavigationClickListener(view: View, id: Int, extras: FragmentNavigator.Extras? = null)=
        view.setOnClickListener {
            findNavController().navigate(id, null, null, extras)
        }

    protected fun isLoading(stateFlow: StateFlow<Boolean>,progressBar: ProgressBar)=
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            stateFlow.collect {
                progressBar.isVisible = it
            }
        }


    protected fun isErrorInternet(stateFlow: StateFlow<Boolean>) =
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            stateFlow.collect {
                if (it) {
                    MaterialAlertDialogBuilder(requireContext())
                        .setMessage("No Internet")
                        .setTitle("check Internet")
                        .setNegativeButton("Exit") { _, _ -> }
                        .show()
                }
            }
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}