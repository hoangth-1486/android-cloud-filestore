package com.hoang.firebase.chatfilestore.screen.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hoang.firebase.chatfilestore.R
import com.hoang.firebase.chatfilestore.data.model.User
import com.hoang.firebase.chatfilestore.data.repository.UserRepositoryImpl
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.edit_password
import kotlinx.android.synthetic.main.fragment_login.edit_username
import kotlinx.android.synthetic.main.fragment_register.*

class LoginFragment : Fragment() {
    val userRepository = UserRepositoryImpl()

    companion object {
        val TAG = "LoginFragmentl"
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_login.setOnClickListener {
            userRepository.login(edit_username.text.toString(), edit_password.text.toString()).addOnSuccessListener {
                for (document in it) {
                    if (document.data["username"] == edit_username.text.toString() && document.data["password"].toString() == edit_password.text.toString()) {
                        Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.add(R.id.container, ChatFragment.newInstance(User(edit_username.text.toString(),edit_password.text.toString())), RegisterFragment.TAG)?.addToBackStack("a")?.commit()
                        return@addOnSuccessListener
                    }
                }

            }
                .addOnFailureListener { }
        }
    }
}