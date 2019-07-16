package com.mateusmendes.whatsappclone.presenter

import com.mateusmendes.whatsappclone.dto.StatusDTO

interface StatusPresenterInterface {
    fun loadAll(): ArrayList<StatusDTO>
}