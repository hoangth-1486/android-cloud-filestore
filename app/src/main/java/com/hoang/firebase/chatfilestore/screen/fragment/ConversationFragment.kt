package com.hoang.firebase.chatfilestore.screen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hoang.firebase.chatfilestore.R
import com.hoang.firebase.chatfilestore.data.repository.UserRepositoryImpl

class ConversationFragment : Fragment() {
    val userRepository = UserRepositoryImpl()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_conversation, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}