package com.hoang.firebase.chatfilestore.screen.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot
import com.hoang.firebase.chatfilestore.R
import com.hoang.firebase.chatfilestore.data.model.Message
import com.hoang.firebase.chatfilestore.data.model.User
import com.hoang.firebase.chatfilestore.data.repository.ChatRepository
import com.hoang.firebase.chatfilestore.data.repository.ChatRepositoryImpl
import kotlinx.android.synthetic.main.chat_fragment.*
import kotlinx.android.synthetic.main.fragment_conversation.*

class ChatFragment : Fragment() {
    companion object {
        fun newInstance(user: User) = ChatFragment().apply {
            arguments = Bundle().apply {
                putParcelable("user", user)
            }
        }
    }

    val chatRepository: ChatRepository = ChatRepositoryImpl()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.chat_fragment, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val user: User? = arguments?.getParcelable("user")
        chatRepository.getConversatiuon().orderBy("time").addSnapshotListener { a, b ->
            val listMess = a?.documents?.map {
                it.toObject(Message::class.java)
            }
            recycler_chat.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ChatAdapter(listMess as List<Message>)
            }
        }
        button_send.setOnClickListener {
            chatRepository.chat(Message(user, edit_message.text.toString(), System.currentTimeMillis()))
        }
    }

}