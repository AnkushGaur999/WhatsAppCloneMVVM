package com.example.whatsappclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R

class CallsAdapter: RecyclerView.Adapter<CallsAdapter.CallsViewHolder>() {

    inner class CallsViewHolder(view:View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallsViewHolder {
        return CallsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.call_item, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: CallsViewHolder, position: Int) {

    }
}