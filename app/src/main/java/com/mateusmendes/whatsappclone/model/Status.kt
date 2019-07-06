package com.mateusmendes.whatsappclone.model

import java.io.Serializable
import java.util.*

class Status(
    val id: String,
    val createdAt: Date,
    val owner: User,
    val vizializedBy: ArrayList<User>
): Serializable {
}