package com.mateusmendes.whatsappclone.presenter

import com.mateusmendes.whatsappclone.model.Chat

interface ChatPresenterInterface {
    fun loadAll(): ArrayList<Chat>
    fun getChatByContact(id: String): Chat?
}