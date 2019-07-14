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
import com.mateusmendes.whatsappclone.presenter.ChatPresenter
import com.mateusmendes.whatsappclone.presenter.ChatPresenterInterface

class ChatsFragment : Fragment() {
    lateinit var chatPresenter: ChatPresenterInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        chatPresenter = ChatPresenter(resources)
        val chatList: RecyclerView = view.findViewById(R.id.chat_list)
        val chatsAdapter = ChatsAdapter(chatPresenter.loadAll())

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

        chatList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = chatsAdapter
        }

        return view
    }
}
