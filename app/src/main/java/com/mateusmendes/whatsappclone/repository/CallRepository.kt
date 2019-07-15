package com.mateusmendes.whatsappclone.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Call
import com.mateusmendes.whatsappclone.utils.ResourceUtil

class CallRepository(
    resources: Resources
): BaseRepository<Call>(
    R.raw.calls,
    object : TypeToken<ArrayList<Call>>(){}.type,
    ResourceUtil(resources)
), CallRepositoryInterface {
}