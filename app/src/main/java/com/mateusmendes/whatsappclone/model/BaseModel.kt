package com.mateusmendes.whatsappclone.model

import java.io.Serializable
import java.util.*
import java.util.UUID.*

open class BaseModel: Serializable {
    val id = randomUUID().toString()
    var createdAt = Date()
}