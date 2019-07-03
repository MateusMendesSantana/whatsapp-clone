package com.mateusmendes.whatsappclone.model

class Chat(
    val id: String,
    val name: String,
    val owner: User,
    val participants: List<User>,
    val messages: List<Message>
) {
}