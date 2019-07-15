package com.mateusmendes.whatsappclone.model

import java.io.Serializable
import kotlin.collections.ArrayList

class Chat(
    val name: String,
    val profilePictureGroup: String?,
    val participantsId: ArrayList<String>
): BaseModel(), Serializable {
    var participants = ArrayList<User>()
    val messages = ArrayList<Message>()

    fun getProfilePicture(userId: String): String {
        return if(isGroup()) {
            profilePictureGroup!!
        } else {
            participants.find { it.id != userId }!!.profilePicture
        }
    }

    fun getChatName(userId: String): String {
        return if(isGroup()) {
            name
        } else {
            participants.find { it.id != userId }!!.username
        }
    }

    fun isGroup(): Boolean {
        return participantsId.size > 2
    }
}