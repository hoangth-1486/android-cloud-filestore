package com.hoang.firebase.chatfilestore.data.model

data class Message(val from: User? = null, val message: String? = "", val time: Long = 0)