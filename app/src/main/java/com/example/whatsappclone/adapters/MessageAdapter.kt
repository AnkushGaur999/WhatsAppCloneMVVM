package com.example.whatsappclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.databinding.UserTextMessageItemBinding

class MessageAdapter: RecyclerView.Adapter<MessageAdapter.UserMessageTextViewHolder>() {

    inner class UserMessageTextViewHolder(binding: UserTextMessageItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserMessageTextViewHolder = UserMessageTextViewHolder(
        UserTextMessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = 20


    override fun onBindViewHolder(holder: MessageAdapter.UserMessageTextViewHolder, position: Int) {

    }


}