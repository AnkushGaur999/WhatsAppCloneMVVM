package com.example.whatsappclone.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.whatsappclone.ui.dashboard.calls.CallsFragment
import com.example.whatsappclone.ui.dashboard.chats.ChatsListFragment
import com.example.whatsappclone.ui.dashboard.status.StatusFragment

class AppPagerAdapter(fragmentActivity: FragmentActivity):  FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0-> ChatsListFragment();
            1-> StatusFragment()
            2-> CallsFragment()
            else -> ChatsListFragment()
        }
    }
}