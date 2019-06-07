package com.hoang.firebase.chatfilestore.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.QuerySnapshot
import com.hoang.firebase.chatfilestore.data.model.Message
import com.hoang.firebase.chatfilestore.data.model.User

interface ChatRepository {
    fun chat(message: Message): Task<DocumentReference>
    fun getConversatiuon(): CollectionReference
}