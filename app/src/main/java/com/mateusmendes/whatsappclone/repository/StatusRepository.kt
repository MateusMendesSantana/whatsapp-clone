package com.mateusmendes.whatsappclone.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Status
import com.mateusmendes.whatsappclone.utils.ResourceUtil
import java.util.*
import kotlin.collections.ArrayList
import java.util.concurrent.ThreadLocalRandom


class StatusRepository(
    resources: Resources
): BaseRepository<Status>(
    R.raw.status,
    object : TypeToken<ArrayList<Status>>(){}.type,
    ResourceUtil(resources)
), StatusRepositoryInterface {

    override fun loadAll(): ArrayList<Status> {
        val list = super.loadAll()

        list.forEach { status ->
            status.image = "status${(1..30).random()}"
            status.createdAt = randomDate(yesterday(), Date())
        }

        return list
    }

    private fun yesterday(): Date {
        val cal = Calendar.getInstance()
        cal.add(Calendar.DATE, -1)

        return cal.time
    }

    private fun randomDate(date1: Date, date2: Date): Date{
        return Date(ThreadLocalRandom.current().nextLong(date1.time, date2.time))
    }
}