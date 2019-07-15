package com.mateusmendes.whatsappclone.presenter

import com.mateusmendes.whatsappclone.model.Call

interface CallPresenterInterface {
    fun loadAll(): ArrayList<Call>
}