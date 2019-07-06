package com.mateusmendes.whatsappclone.model

import java.io.Serializable
import java.util.*

class Message(
    val id: String,
    val content: String,
    val isVisualized: Boolean,
    val isualizedAt : Date,
    val isReceived: Boolean,
    val receivedAt: Date,
    val createdAt: Date
): Serializable {
}