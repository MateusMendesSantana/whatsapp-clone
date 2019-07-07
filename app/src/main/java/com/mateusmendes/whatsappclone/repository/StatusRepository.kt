package com.mateusmendes.whatsappclone.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Status
import com.mateusmendes.whatsappclone.utils.ResourceUtil

class StatusRepository(
    resources: Resources
): BaseRepository<Status>(
    R.raw.status,
    object : TypeToken<ArrayList<Status>>(){}.type,
    ResourceUtil(resources)
), StatusRepositoryInterface {
}