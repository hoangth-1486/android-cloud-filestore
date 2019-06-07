package com.hoang.firebase.chatfilestore.screen.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hoang.firebase.chatfilestore.R
import com.hoang.firebase.chatfilestore.data.model.Message
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatAdapter(val listMessage: List<Message>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_chat, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMessage.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.text_username.text = listMessage[position].from?.username
        holder.itemView.text_messagel.text = listMessage[position].message

    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)
}