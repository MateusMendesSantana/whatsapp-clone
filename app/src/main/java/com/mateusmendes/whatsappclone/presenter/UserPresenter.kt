package com.mateusmendes.whatsappclone.presenter

import android.content.res.Resources
import com.mateusmendes.whatsappclone.model.User
import com.mateusmendes.whatsappclone.repository.UserRepository
import com.mateusmendes.whatsappclone.repository.UserRepositoryInterface

class UserPresenter(
    resources: Resources
): UserPresenterInterface {
    private val userRepository: UserRepositoryInterface = UserRepository(resources)

    override fun getUser(): User {
        return userRepository.loadAll()[0]
    }

    override fun loadAll(): ArrayList<User> {
        return userRepository.loadAll()
    }
}