package com.mateusmendes.whatsappclone.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Chat

class ChatsAdapter: RecyclerView.Adapter<ChatsAdapter.ChatsHolder>() {
    var chatList: ArrayList<Chat> = ArrayList()

    class ChatsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textChatTitle: TextView = view.findViewById(R.id.textChatTitle)
        val textLastMessage: TextView = view.findViewById(R.id.textLastMessage)
        val textLastMessageDate: TextView = view.findViewById(R.id.textLastMessageDate)
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

            holder.textLastMessageDate.text = lastMessage.createdAt.toString()
            holder.textLastMessage.text = lastMessage.content
        }
    }

    override fun getItemCount() = chatList.size
}