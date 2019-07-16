package com.mateusmendes.whatsappclone.model

import java.io.Serializable
import kotlin.collections.ArrayList

class Status(
    val ownerId: String,
    var image: String,
    val description: String
): BaseModel(), Serializable {
    val visualizedByIds = ArrayList<String>()
    var visualizedBy = ArrayList<User>()
    var owner: User? = null
}