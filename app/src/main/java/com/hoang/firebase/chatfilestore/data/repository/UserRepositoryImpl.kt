package com.hoang.firebase.chatfilestore.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

class UserRepositoryImpl : UserRepository {
    override fun getAllUser(): Task<QuerySnapshot> {
        return db.collection("users").get()
    }

    val db = FirebaseFirestore.getInstance()
    override fun register(username: String, password: String): Task<DocumentReference> {
        return db.collection("users")
            .add(
                hashMapOf(
                    "username" to username,
                    "password" to password
                )
            )
    }

    override fun login(username: String, password: String): Task<QuerySnapshot> {
        return db.collection("users").get()
    }


}