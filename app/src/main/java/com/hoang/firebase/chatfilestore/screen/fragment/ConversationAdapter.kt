package com.hoang.firebase.chatfilestore.screen.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hoang.firebase.chatfilestore.R
import com.hoang.firebase.chatfilestore.data.model.User
import kotlinx.android.synthetic.main.item_conversation.view.*

class ConversationAdapter(val listUser: List<User>) : RecyclerView.Adapter<ConversationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_conversation, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.text_name.text = listUser[position].username
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}