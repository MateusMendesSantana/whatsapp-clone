package com.mateusmendes.whatsappclone.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.User
import com.mateusmendes.whatsappclone.presenter.ChatPresenter
import com.mateusmendes.whatsappclone.presenter.ChatPresenterInterface
import com.mateusmendes.whatsappclone.presenter.UserPresenter
import com.mateusmendes.whatsappclone.presenter.UserPresenterInterface
import kotlinx.android.synthetic.main.activity_contact_list.*
import kotlinx.android.synthetic.main.chat_toolbar.actionMenuView
import kotlinx.android.synthetic.main.chat_toolbar.textTotalContacts

class ContactListActivity : AppCompatActivity() {
    private lateinit var userPresenter: UserPresenterInterface
    private lateinit var chatPresenter: ChatPresenterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        userPresenter = UserPresenter(resources)
        chatPresenter = ChatPresenter(resources)

        val contactList = userPresenter.loadAll()

        configureToolbar()
        setTotalContacts(contactList.size)
        configureRecycler(contactList)
    }

    private fun configureToolbar() {
        val contactListToolbar: Toolbar = findViewById(R.id.contactListToolbar)

        contactListToolbar.setNavigationOnClickListener { onBackPressed() }
        setSupportActionBar(contactListToolbar)
    }

    private fun configureRecycler(contacts: ArrayList<User>) {
        val contactAdapter = ContactAdapter(this, contacts)

        contactAdapter.setOnItemClickListener(object:ContactAdapter.ClickListener{
            override fun onItemClick(index: Int, view: View) {
                val intent = Intent(view.context, ChatActivity::class.java)

                intent.putExtra("chat", contactAdapter.getItem(index))
                startActivity(intent)
            }

            override fun onItemLongClick(index: Int, view: View) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        contactListRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = contactAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_contacts, actionMenuView.menu)

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

    private fun setTotalContacts(total: Int) {
        textTotalContacts.text = "$total total"
    }
}
