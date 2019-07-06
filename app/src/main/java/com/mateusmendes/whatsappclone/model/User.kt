package com.mateusmendes.whatsappclone.model

import java.io.Serializable

class User(
    val id: String,
    val username: String,
    val email: String,
    val password: String
): Serializable {
}