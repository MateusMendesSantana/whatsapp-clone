package com.mateusmendes.whatsappclone.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Chat
import com.mateusmendes.whatsappclone.utils.ResourceUtil

class ChatRepository(
    resources: Resources
): BaseRepository<Chat>(
    R.raw.chats,
    object : TypeToken<ArrayList<Chat>>(){}.type,
    ResourceUtil(resources)
), ChatRepositoryInterface {

}