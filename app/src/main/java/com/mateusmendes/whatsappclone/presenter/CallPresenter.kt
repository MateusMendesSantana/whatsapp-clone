package com.mateusmendes.whatsappclone.presenter

import android.content.res.Resources
import com.mateusmendes.whatsappclone.model.Call
import com.mateusmendes.whatsappclone.model.User
import com.mateusmendes.whatsappclone.repository.CallRepository
import com.mateusmendes.whatsappclone.repository.CallRepositoryInterface
import com.mateusmendes.whatsappclone.repository.UserRepository
import com.mateusmendes.whatsappclone.repository.UserRepositoryInterface

class CallPresenter(
    resources: Resources
): CallPresenterInterface {
    private val callRepository: CallRepositoryInterface = CallRepository(resources)
    private val userRepository: UserRepositoryInterface = UserRepository(resources)

    override fun loadAll(): ArrayList<Call> {
        val list = callRepository.loadAll()

        list.forEach { call ->
            call.owner = userRepository.getById(call.ownerId)
            call.participants = call.participantsId.map { participantId ->
                userRepository.getById(participantId)!!
            } as ArrayList<User>
        }

        return list
    }
}