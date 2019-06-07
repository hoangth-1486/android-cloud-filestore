package com.hoang.firebase.chatfilestore.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.hoang.firebase.chatfilestore.data.model.Message
import com.hoang.firebase.chatfilestore.data.model.User

class ChatRepositoryImpl : ChatRepository {
    override fun getConversatiuon(): CollectionReference {
        return db.collection("chatroom")
    }

    val db = FirebaseFirestore.getInstance()

    override fun chat(message: Message): Task<DocumentReference> {
        return db.collection("chatroom").add(
            message
        )
    }
}