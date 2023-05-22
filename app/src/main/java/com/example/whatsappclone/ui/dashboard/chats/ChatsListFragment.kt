package com.example.whatsappclone.ui.dashboard.chats

import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.whatsappclone.R
import com.example.whatsappclone.adapters.ChatAdapter
import com.example.whatsappclone.databinding.FragmentChatsListBinding


class ChatsListFragment : Fragment()  {

    private var _binding: FragmentChatsListBinding? = null
    private val binding: FragmentChatsListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChatsListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ChatAdapter()

        adapter.setOnLongClickListener(object : ChatAdapter.OnChatLongClick{
            override fun onChatLongClick(message: String, view: View)  {
                // creating a object of Popupmenu
                val popupMenu = PopupMenu(requireContext(), view)

                // we need to inflate the object
                // with popup_menu.xml file
                popupMenu.inflate(R.menu.chat_item_click_menu)
                try {
                    val popup = PopupMenu::class.java.getDeclaredField("mPopup")
                    popup.isAccessible = true
                    val menu = popup.get(popupMenu)
                    menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                        .invoke(menu,true)
                }
                catch (e: Exception)
                {
                    Log.d("error", e.toString())
                }
                finally {
                    popupMenu.show()
                }
            }

        })

        adapter.setOnChatClickListener(object: ChatAdapter.OnChatClick{
            override fun onChatClick() {
               findNavController().navigate(R.id.action_mainFragment_to_fragmentChat)
            }
        })
        val animation = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_right_to_left)
        binding.chatRecyclerView.layoutAnimation = animation
        binding.chatRecyclerView.adapter = adapter
        binding.chatRecyclerView.scheduleLayoutAnimation()

    }

}