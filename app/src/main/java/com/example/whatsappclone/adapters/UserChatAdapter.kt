package com.example.whatsappclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.model.Chat

class UserChatAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val chatList = arrayListOf<Chat>()

    inner class UserChatReceiveViewHolder(view: View): RecyclerView.ViewHolder(view){

    }
    inner class UserChatSentViewHolder(view: View): RecyclerView.ViewHolder(view){
        val sentMessageTV = itemView.findViewById<TextView>(R.id.sent_msg_txt_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType==0) UserChatSentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_message_sent, parent, false))
        else UserChatReceiveViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_message_received, parent, false))

    }

    fun addChat(chat: Chat){
        chatList.add(chat)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val type = chatList[position]
        return if (type.type==0) 0
        else 1;
    }

    override fun getItemCount(): Int {
        return chatList.size;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val type = chatList[position].type
        if(type==0){
            (holder as UserChatSentViewHolder).sentMessageTV.text = chatList[position].message
        }

    }


}