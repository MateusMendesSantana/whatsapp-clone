package com.mateusmendes.whatsappclone.model

import java.io.Serializable
import kotlin.collections.ArrayList

class Chat(
    val name: String,
    val ownerId: String,
    val participantsId: ArrayList<String>,
    val owner: User?
): BaseModel(), Serializable {
    val participants = ArrayList<User>()
    val messages = ArrayList<Message>()
}