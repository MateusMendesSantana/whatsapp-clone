package com.mateusmendes.whatsappclone.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Status
import java.util.*
import kotlin.collections.ArrayList
import java.text.SimpleDateFormat


class StatusAdapter: RecyclerView.Adapter<StatusAdapter.StatusHolder>() {
    var statusList: ArrayList<Status> = ArrayList()

    class StatusHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textStatusTitle: TextView = view.findViewById(R.id.text_status_title)
        val textCreatedAt: TextView = view.findViewById(R.id.text_created_at)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.status_item, parent, false)

        return StatusHolder(view)
    }

    override fun onBindViewHolder(holder: StatusHolder, position: Int) {
        val status = statusList[position]

        holder.textStatusTitle.text = status.owner.username

        val minutes = (Date().time - status.createdAt.time) / 1000 / 60

        if(minutes < 60) {
            holder.textCreatedAt.text = """$minutes minutes ago"""
        } else {
            val formatter = SimpleDateFormat("dddd hh:mm a")
            holder.textCreatedAt.text = formatter.format(status.createdAt)
        }
    }

    override fun getItemCount() = statusList.size
}