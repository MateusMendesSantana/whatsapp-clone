package com.mateusmendes.whatsappclone.model

import java.io.Serializable
import java.time.Duration

class Call(
    val ownerId: String,
    var owner: User?,
    val duration: Duration,
    val participantsId: ArrayList<String>,
    var participants: ArrayList<User>?
): BaseModel(), Serializable {
}