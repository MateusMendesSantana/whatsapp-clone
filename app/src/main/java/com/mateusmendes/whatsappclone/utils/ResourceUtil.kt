package com.mateusmendes.whatsappclone.utils

import android.content.res.Resources
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mateusmendes.whatsappclone.model.BaseModel
import java.io.InputStream
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList
import com.google.gson.GsonBuilder



class ResourceUtil(
    private val resources: Resources
) {
    private val gson = GsonBuilder().serializeNulls().create()

    fun <Model> load(id: Int, collectionType: Type): ArrayList<Model> where Model: BaseModel{
        val json = readRawResource(id)

        return gson.fromJson(json, collectionType)
    }

    private fun readRawResource(res: Int): String {
        return readStream(resources.openRawResource(res))
    }

    private fun readStream(inputStream: InputStream): String {
        val scanner = Scanner(inputStream).useDelimiter("\\A")

        return if (scanner.hasNext()) scanner.next() else ""
    }
}