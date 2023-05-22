package com.example.whatsappclone.ui.dashboard.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.whatsappclone.R
import com.example.whatsappclone.adapters.StatusAdapter
import com.example.whatsappclone.databinding.FragmentStatusBinding


class StatusFragment : Fragment() {

    private var _binding:FragmentStatusBinding? =null
    private val binding: FragmentStatusBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStatusBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = StatusAdapter()
        val animation = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_right_to_left)

        binding.recyclerMutedUpdates.adapter = adapter
        adapter.notifyDataSetChanged()
        binding.recyclerMutedUpdates.layoutAnimation = animation
        binding.recyclerMutedUpdates.scheduleLayoutAnimation()

        binding.recyclerViewedUpdates.adapter = adapter
        adapter.notifyDataSetChanged()
        binding.recyclerViewedUpdates.layoutAnimation = animation
        binding.recyclerViewedUpdates.scheduleLayoutAnimation()

        binding.recyclerRecentUpdates.adapter = adapter
        adapter.notifyDataSetChanged()
        binding.recyclerRecentUpdates.layoutAnimation = animation
        binding.recyclerViewedUpdates.scheduleLayoutAnimation()

    }

}