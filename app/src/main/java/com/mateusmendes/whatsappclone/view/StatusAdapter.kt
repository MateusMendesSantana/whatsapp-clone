package com.mateusmendes.whatsappclone.view

import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.dto.StatusDTO
import com.mateusmendes.whatsappclone.resIdByName
import java.util.*
import kotlin.collections.ArrayList
import java.text.SimpleDateFormat
import android.graphics.Color
import android.widget.ImageView
import com.mikhaellopez.circularimageview.CircularImageView

class StatusAdapter(
    private val statusList: ArrayList<StatusDTO>
): RecyclerView.Adapter<StatusAdapter.StatusHolder>() {
    private val formatter = SimpleDateFormat("EEEE, h:mm a")

    class StatusHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageBackground: ImageView = view.findViewById(R.id.imageBackground)
        val imageStatus: CircularImageView = view.findViewById(R.id.imageStatus)
        val textStatusTitle: TextView = view.findViewById(R.id.text_status_title)
        val textCreatedAt: TextView = view.findViewById(R.id.text_created_at)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.status_item, parent, false)

        return StatusHolder(view)
    }

    override fun onBindViewHolder(holder: StatusHolder, position: Int) {
        val statusDTO = statusList[position]
        val lastStatus = statusDTO.lastStatus()
        val context = holder.imageStatus.context
        val resources = context.resources
        val res = holder.imageStatus.context.resIdByName(lastStatus.image,"drawable")

        val dashWidth = statusDTO.getDashWidth()
        val dashGap = statusDTO.getDashGap()
        val statusDottedBackground = CircularDottedDrawable(resources, Color.GRAY, 2f, dashWidth, dashGap)
        holder.imageBackground.background = statusDottedBackground
        holder.imageStatus.setImageResource(res)
        holder.textStatusTitle.text = statusDTO.owner.username

        val minutes = (Date().time - lastStatus.createdAt.time) / 1000 / 60

        if(minutes < 60) {
            holder.textCreatedAt.text = "$minutes minutes ago"
        } else {
            holder.textCreatedAt.text = formatter.format(lastStatus.createdAt)
        }
    }

    override fun getItemCount() = statusList.size
}