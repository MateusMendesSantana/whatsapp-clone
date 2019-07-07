package com.mateusmendes.whatsappclone.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Chat
import com.mateusmendes.whatsappclone.model.User
import com.mateusmendes.whatsappclone.presenter.UserPresenter
import com.mateusmendes.whatsappclone.presenter.UserPresenterInterface
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    lateinit var userPresenter: UserPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        userPresenter = UserPresenter(resources)

        val chat = intent.getSerializableExtra("chat") as Chat
        val user = userPresenter.getUser()
        val messagesAdapter = MessagesAdapter(user.id, chat.messages)

        recycler_chat.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = messagesAdapter
        }
    }
}
