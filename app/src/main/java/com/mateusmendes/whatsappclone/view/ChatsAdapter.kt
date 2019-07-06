package com.mateusmendes.whatsappclone.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Chat
import java.text.SimpleDateFormat

class ChatsAdapter: RecyclerView.Adapter<ChatsAdapter.ChatsHolder>() {
    private var clickListener: ClickListener? = null
    var chatList: ArrayList<Chat> = ArrayList()

    inner class ChatsHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
        val textChatTitle: TextView = view.findViewById(R.id.textChatTitle)
        val textLastMessage: TextView = view.findViewById(R.id.textLastMessage)
        val textLastMessageDate: TextView = view.findViewById(R.id.textLastMessageDate)

        init {
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }

        override fun onClick(view: View) {
            clickListener!!.onItemClick(adapterPosition, view)
        }

        override fun onLongClick(view: View): Boolean {
            clickListener!!.onItemLongClick(adapterPosition, view)
            return false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)

        return ChatsHolder(view)
    }

    override fun onBindViewHolder(holder: ChatsHolder, position: Int) {
        val chat = chatList[position]

        holder.textChatTitle.text = chat.name

        if(chat.messages.isNotEmpty()) {
            val lastMessage = chat.messages.last()
            val format = SimpleDateFormat("hh:mm a")

            holder.textLastMessageDate.text = format.format(lastMessage.createdAt)
            holder.textLastMessage.text = lastMessage.content
        }
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