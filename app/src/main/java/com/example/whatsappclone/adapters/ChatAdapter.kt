package com.example.whatsappclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.google.android.material.snackbar.Snackbar

class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    private lateinit var onChatLongClick: OnChatLongClick
    private lateinit var onChatClick: OnChatClick

    inner class ChatViewHolder(view: View): RecyclerView.ViewHolder(view){
        val userName: TextView = itemView.findViewById(R.id.userName)
    }

    fun setOnLongClickListener(onChatLongClick: OnChatLongClick){
        this.onChatLongClick = onChatLongClick
    }

    fun  setOnChatClickListener(onChatClick: OnChatClick){
        this.onChatClick = onChatClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener{
            if(onChatLongClick!=null){
                onChatLongClick.onChatLongClick("Item clicked", holder.userName)
            }
            true
        }
        holder.itemView.setOnClickListener {
            if(onChatClick!=null){
                onChatClick.onChatClick()
            }
        }
    }

     interface OnChatLongClick{
         fun onChatLongClick(message: String, view: View)
     }

    interface OnChatClick{
        fun onChatClick()
    }
}