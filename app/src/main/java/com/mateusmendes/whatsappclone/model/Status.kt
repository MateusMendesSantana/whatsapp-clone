package com.mateusmendes.whatsappclone.model

import java.io.Serializable
import kotlin.collections.ArrayList

class Status(
    val ownerId: String,
    var owner: User?
): BaseModel(), Serializable {
    val visualizedBy = ArrayList<User>()
}