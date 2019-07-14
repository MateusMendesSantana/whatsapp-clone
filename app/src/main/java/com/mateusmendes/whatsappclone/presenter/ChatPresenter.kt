package com.mateusmendes.whatsappclone.presenter

import android.content.res.Resources
import com.mateusmendes.whatsappclone.model.Chat
import com.mateusmendes.whatsappclone.repository.ChatRepository
import com.mateusmendes.whatsappclone.repository.ChatRepositoryInterface
import com.mateusmendes.whatsappclone.repository.UserRepository
import com.mateusmendes.whatsappclone.repository.UserRepositoryInterface

class ChatPresenter(
    resources: Resources
): ChatPresenterInterface {
    private val chatRepository: ChatRepositoryInterface = ChatRepository(resources)
    private val userRepository: UserRepositoryInterface = UserRepository(resources)

    override fun loadAll(): ArrayList<Chat> {
        val list = chatRepository.loadAll()

        list.forEach {
            it.owner = userRepository.getById(it.ownerId)
        }

        return list
    }

    override fun getOrCreateChatByContact(id: String): Chat {
        val chat = getChatByContact(id)
        val user = userRepository.getById(id)

        return chat ?: Chat("ggdfgfd", "", ArrayList(), user)
    }

    override fun getChatByContact(id: String): Chat? {
        val list = loadAll()

        return list.find { it.participantsId.contains(id) }
    }
}