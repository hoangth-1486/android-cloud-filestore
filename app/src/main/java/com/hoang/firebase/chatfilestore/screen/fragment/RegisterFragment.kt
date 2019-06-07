package com.hoang.firebase.chatfilestore.screen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hoang.firebase.chatfilestore.R
import com.hoang.firebase.chatfilestore.data.repository.UserRepository
import com.hoang.firebase.chatfilestore.data.repository.UserRepositoryImpl
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {
    companion object {
        val TAG = "MainFragment"
        fun newInstance() = RegisterFragment()
    }

    val userRepository: UserRepository = UserRepositoryImpl()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_register, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_register.setOnClickListener {
            userRepository.register(edit_username.text.toString(), edit_password.text.toString())
                .addOnSuccessListener {
                    activity?.supportFragmentManager?.popBackStack()
                }
                .addOnFailureListener {

                }
        }
    }
}