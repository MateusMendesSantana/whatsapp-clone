package com.mateusmendes.whatsappclone.presenter

import com.mateusmendes.whatsappclone.model.Status

interface StatusPresenterInterface {
    fun loadAll(): ArrayList<Status>
}