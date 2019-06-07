package com.hoang.firebase.chatfilestore.screen.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.hoang.firebase.chatfilestore.R
import com.hoang.firebase.chatfilestore.screen.fragment.LoginFragment
import com.hoang.firebase.chatfilestore.screen.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager?.beginTransaction()?.add(R.id.container, MainFragment.newInstance(), MainFragment.TAG)
            ?.commit()
    }
}
