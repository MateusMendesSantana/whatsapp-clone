package com.mateusmendes.whatsappclone.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mateusmendes.whatsappclone.R
import android.content.Intent
import android.support.design.widget.FloatingActionButton
import com.mateusmendes.whatsappclone.model.Chat
import com.mateusmendes.whatsappclone.presenter.ChatPresenter
import com.mateusmendes.whatsappclone.presenter.ChatPresenterInterface

class ChatsFragment : Fragment() {
    lateinit var chatPresenter: ChatPresenterInterface
    lateinit var recyclerViewChat: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        chatPresenter = ChatPresenter(resources)
        recyclerViewChat = view.findViewById(R.id.chat_list)

        val chatList = chatPresenter.loadAll()

        configureRecycler(chatList)

        val buttonMessages: FloatingActionButton = view.findViewById(R.id.buttonMessages)

        buttonMessages.bringToFront()
        buttonMessages.setOnClickListener {
            val intent = Intent(context, ContactListActivity::class.java)

            startActivity(intent)
        }

        return view
    }

    private fun configureRecycler(chats: ArrayList<Chat>) {
        val chatsAdapter = ChatsAdapter(chats)

        chatsAdapter.setOnItemClickListener(object:ChatsAdapter.ClickListener{
            override fun onItemClick(index: Int, view: View) {
                val intent = Intent(context, ChatActivity::class.java)

                intent.putExtra("chat", chatsAdapter.chatList[index])
                startActivity(intent)
            }

            override fun onItemLongClick(index: Int, view: View) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        recyclerViewChat.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = chatsAdapter
        }
    }
}
