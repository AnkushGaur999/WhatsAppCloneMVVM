package com.example.whatsappclone.ui.main_fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.whatsappclone.R
import com.example.whatsappclone.adapters.AppPagerAdapter
import com.example.whatsappclone.databinding.FragmentMainBinding
import com.example.whatsappclone.ui.setting.SettingFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!
    private val title = arrayListOf("Chats", "Status", "Calls")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater)

        (activity as AppCompatActivity).setSupportActionBar(binding.mainToolbar)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AppPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.viewPager){
                tab, position->
            tab.text = title[position]
            val badge = tab.orCreateBadge
            badge.number = position

            if(position==0) badge.number = 100
            if(position==1) badge.number = 23
            if(position==2) badge.number = 120

        }.attach()

        setupMenuBar()
    }

    private fun setupMenuBar(){

        (requireActivity() as MenuHost).addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu , menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                when(menuItem.itemId){

                    R.id.main_setting ->{
                        findNavController().navigate(R.id.action_mainFragment_to_settingFragment)
                    }
                    R.id.main_camera ->{}
                    R.id.main_payment ->{}
                    R.id.main_search ->{}
                    R.id.main_linked_device ->{}

                }

               return true
            }



        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }

}