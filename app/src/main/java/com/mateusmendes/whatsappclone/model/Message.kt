package com.mateusmendes.whatsappclone.model

import java.io.Serializable

class Message(
    val content: String,
    val ownerId: String,
    val owner: User?
): BaseModel(), Serializable {
    val status: MessageStatus = MessageStatus.CREATED
    val isVisualized: Boolean = false
    var isVisualizedAt = null
    var isReceived = false
    val receivedAt = null
}