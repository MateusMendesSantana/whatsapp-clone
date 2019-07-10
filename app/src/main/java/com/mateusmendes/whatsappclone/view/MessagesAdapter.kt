package com.mateusmendes.whatsappclone.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Message

class MessagesAdapter(
    private val userId: String,
    private val chatList: ArrayList<Message>
): RecyclerView.Adapter<MessagesAdapter.MessageHolder>() {
    private var clickListener: ClickListener? = null

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
        val layout = when(viewType) {
            0 -> R.layout.message_item_out
            1 -> R.layout.message_item_in
            else -> R.layout.message_item_out
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return MessageHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        val message = chatList[position]

        return if (message.ownerId == userId) 1 else 0
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