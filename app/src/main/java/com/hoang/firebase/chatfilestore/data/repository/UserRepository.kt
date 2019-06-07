package com.hoang.firebase.chatfilestore.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.QuerySnapshot

interface UserRepository {
    fun register(username: String, password: String): Task<DocumentReference>
    fun login(username: String, password: String): Task<QuerySnapshot>
    fun getAllUser(): Task<QuerySnapshot>
}