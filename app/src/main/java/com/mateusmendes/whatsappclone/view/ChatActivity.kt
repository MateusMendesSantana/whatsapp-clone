package com.mateusmendes.whatsappclone.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Chat
import com.mateusmendes.whatsappclone.presenter.UserPresenter
import com.mateusmendes.whatsappclone.presenter.UserPresenterInterface
import kotlinx.android.synthetic.main.activity_chat.*
import android.widget.Toast
import android.view.MenuItem
import android.view.Menu
import com.mateusmendes.whatsappclone.model.Message
import com.mateusmendes.whatsappclone.model.User
import com.mateusmendes.whatsappclone.resIdByName
import kotlinx.android.synthetic.main.chat_toolbar.*

class ChatActivity : AppCompatActivity() {
    private lateinit var userPresenter: UserPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        userPresenter = UserPresenter(resources)

        val chat = intent.getSerializableExtra("chat") as Chat

        configureToolbar()
        setInfo(chat)
        configureRecycler(chat.messages)
    }

    private fun configureToolbar() {
        val toolbar = includeToolbar!! as Toolbar

        toolbar.setNavigationOnClickListener { onBackPressed() }
        setSupportActionBar(toolbar)
    }

    private fun configureRecycler(messages: ArrayList<Message>) {
        val user = userPresenter.getUser()
        val messagesAdapter = MessagesAdapter(user.id, messages)

        recycler_chat.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = messagesAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_chat, actionMenuView.menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_call -> {
                Toast.makeText(this, "Action call clicked", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(this, "Action clicked", Toast.LENGTH_LONG).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setInfo(chat: Chat) {
        val userId = userPresenter.getUser().id
        val profilePicture = chat.getProfilePicture(userId)
        val profilePictureResource = resIdByName(profilePicture, "drawable")

        imageContact.setImageResource(profilePictureResource)
        chatUsername.text = chat.getChatName(userId)
        textTotalContacts.text = "online"
    }
}
