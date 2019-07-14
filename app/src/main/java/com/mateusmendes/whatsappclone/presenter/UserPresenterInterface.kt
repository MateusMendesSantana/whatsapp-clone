package com.mateusmendes.whatsappclone.presenter

import com.mateusmendes.whatsappclone.model.User

interface UserPresenterInterface {
    fun getUser(): User
    fun loadAll(): ArrayList<User>
}