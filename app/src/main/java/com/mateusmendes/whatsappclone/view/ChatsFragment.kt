package com.mateusmendes.whatsappclone.view

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Chat
import com.mateusmendes.whatsappclone.model.User
import android.content.Intent
import com.mateusmendes.whatsappclone.model.Message
import java.util.*
import kotlin.collections.ArrayList

class ChatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        val chatList: RecyclerView = view.findViewById(R.id.chat_list)
        val buttonContacts: FloatingActionButton = view.findViewById(R.id.floating_action_button)
        val chatsAdapter = ChatsAdapter()

        val messages = ArrayList<Message>()
        messages.add(Message("","With WhatsApp, you'll get fast, simple, secure messaging and calling for free*, available on phones all over the world.",
            false, Date(), false, Date(), Date()))
        val user = User("","","","")
        val chat = Chat("fsdfg", "Mateus Mendes Santana", user, ArrayList(), messages)
        chatsAdapter.chatList.add(chat)

        chatsAdapter.setOnItemClickListener(object:ChatsAdapter.ClickListener{
            override fun onItemClick(position: Int, view: View) {
                val intent = Intent(context, ChatActivity::class.java)

                intent.putExtra("chat", chatsAdapter.chatList[position])
                startActivity(intent)
            }

            override fun onItemLongClick(position: Int, view: View) {
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
