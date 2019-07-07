package com.mateusmendes.whatsappclone.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.User
import com.mateusmendes.whatsappclone.utils.ResourceUtil

class UserRepository(
    resources: Resources
): BaseRepository<User>(
    R.raw.users,
    object : TypeToken<ArrayList<User>>(){}.type,
    ResourceUtil(resources)
), UserRepositoryInterface {

    override fun getById(id: String): User? {
        return data.find { it.id == id }
    }
}