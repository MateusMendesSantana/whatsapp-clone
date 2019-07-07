package com.mateusmendes.whatsappclone.repository

interface BaseRepositoryInterface<Model> {
    fun getById(id: String): Model?
    fun deleteById(id: String)
    fun loadAll(): ArrayList<Model>
}