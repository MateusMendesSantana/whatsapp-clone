package com.mateusmendes.whatsappclone.view


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Call
import com.mateusmendes.whatsappclone.presenter.*

class CallsFragment : Fragment() {
    lateinit var callPresenter: CallPresenterInterface
    lateinit var userPresenter: UserPresenterInterface
    lateinit var callRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calls, container, false)

        callPresenter = CallPresenter(resources)
        userPresenter = UserPresenter(resources)
        callRecyclerView = view.findViewById(R.id.callRecyclerView)

        val calls = callPresenter.loadAll()

        configureRecycler(calls)

        val buttonNewCall: FloatingActionButton = view.findViewById(R.id.buttonNewCall)

        buttonNewCall.bringToFront()
        buttonNewCall.setOnClickListener {
            val intent = Intent(context, ContactListActivity::class.java)

            startActivity(intent)
        }

        return view
    }

    private fun configureRecycler(calls: ArrayList<Call>) {
        val user = userPresenter.getUser()
        val callsAdapter = CallsAdapter(user.id, calls)

        callsAdapter.setOnItemClickListener(object:CallsAdapter.ClickListener{
            override fun onItemClick(index: Int, view: View) {
            }

            override fun onItemLongClick(index: Int, view: View) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        callRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = callsAdapter
        }
    }
}
