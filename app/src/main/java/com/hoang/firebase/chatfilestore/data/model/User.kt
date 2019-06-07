package com.hoang.firebase.chatfilestore.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(val username: String = "", val password: String = "") : Parcelable