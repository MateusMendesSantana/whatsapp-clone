package com.mateusmendes.whatsappclone.presenter

import android.content.res.Resources
import com.mateusmendes.whatsappclone.model.Status
import com.mateusmendes.whatsappclone.repository.StatusRepository
import com.mateusmendes.whatsappclone.repository.StatusRepositoryInterface
import com.mateusmendes.whatsappclone.repository.UserRepository
import com.mateusmendes.whatsappclone.repository.UserRepositoryInterface

class StatusPresenter(
    resources: Resources
): StatusPresenterInterface {
    private val statusRepository: StatusRepositoryInterface = StatusRepository(resources)
    private val userRepository: UserRepositoryInterface = UserRepository(resources)

    override fun loadAll(): ArrayList<Status> {
        val list = statusRepository.loadAll()

        list.forEach {
            it.owner = userRepository.getById(it.ownerId)
        }

        return list
    }
}