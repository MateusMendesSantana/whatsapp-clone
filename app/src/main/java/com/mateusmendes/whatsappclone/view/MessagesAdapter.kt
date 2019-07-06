package com.mateusmendes.whatsappclone.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Message

class MessagesAdapter: RecyclerView.Adapter<MessagesAdapter.MessageHolder>() {
    private var clickListener: ClickListener? = null
    var chatList: ArrayList<Message> = ArrayList()

    inner class MessageHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
        val textMessage: TextView = view.findViewById(R.id.textMessage)

        override fun onClick(view: View) {
            clickListener!!.onItemClick(adapterPosition, view)
        }

        override fun onLongClick(view: View): Boolean {
            clickListener!!.onItemLongClick(adapterPosition, view)
            return false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_item_in, parent, false)

        return MessageHolder(view)
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        val message = chatList[position]

        holder.textMessage.text = message.content
    }

    override fun getItemCount() = chatList.size

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    interface ClickListener {
        fun onItemClick(position: Int, v: View)
        fun onItemLongClick(position: Int, v: View)
    }
}