package com.mateusmendes.whatsappclone.model

import java.io.Serializable

class Chat(
    val id: String,
    val name: String,
    val owner: User,
    val participants: ArrayList<User>,
    val messages: ArrayList<Message>
): Serializable {
}