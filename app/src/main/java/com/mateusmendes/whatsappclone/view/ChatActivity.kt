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
import com.mateusmendes.whatsappclone.model.User
import kotlinx.android.synthetic.main.chat_toolbar.*
import kotlinx.android.synthetic.main.chat_toolbar.view.*

class ChatActivity : AppCompatActivity() {
    lateinit var userPresenter: UserPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        val toolbar = includeToolbar!! as Toolbar
        toolbar.setNavigationOnClickListener { onBackPressed() }
        setSupportActionBar(toolbar)

        userPresenter = UserPresenter(resources)

        val chat = intent.getSerializableExtra("chat") as Chat
        val user = userPresenter.getUser()
        val messagesAdapter = MessagesAdapter(user.id, chat.messages)

        setUserInfo(chat.owner!!)

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
            R.id.home -> onBackPressed()
            R.id.action_call -> {
                Toast.makeText(this, "Action call clicked", Toast.LENGTH_LONG).show()
            }
            else -> {
                Toast.makeText(this, "Action clicked", Toast.LENGTH_LONG).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setUserInfo(user: User) {
        chatUsername.text = user.username
        chatUserLastSeen.text = "online"
    }
}
