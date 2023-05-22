package com.example.whatsappclone.ui.dashboard.calls

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.whatsappclone.R
import com.example.whatsappclone.adapters.CallsAdapter
import com.example.whatsappclone.databinding.FragmentCallsBinding

class CallsFragment : Fragment() {

    private var _binding:FragmentCallsBinding? = null
    private val binding: FragmentCallsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCallsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CallsAdapter()
        val animation = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_right_to_left)
        binding.callRecyclerView.adapter = adapter
        binding.callRecyclerView.layoutAnimation = animation
        binding.callRecyclerView.scheduleLayoutAnimation()

    }

}