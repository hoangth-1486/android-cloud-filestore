package com.hoang.firebase.chatfilestore.screen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hoang.firebase.chatfilestore.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    companion object {
        val TAG = "MainFragment"
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_register.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.container, RegisterFragment.newInstance(), RegisterFragment.TAG)?.addToBackStack("a")?.commit()
        }
        button_login.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.container, LoginFragment.newInstance(), LoginFragment.TAG)?.addToBackStack("a")?.commit()
        }
    }
}