package com.mateusmendes.whatsappclone.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Chat
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val chat = intent.getSerializableExtra("chat") as Chat
        val messagesAdapter = MessagesAdapter()
        messagesAdapter.chatList = chat.messages

        recycler_chat.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = messagesAdapter
        }
    }
}
