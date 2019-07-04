package com.mateusmendes.whatsappclone.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Status
import com.mateusmendes.whatsappclone.model.User
import java.util.*
import kotlin.collections.ArrayList

class StatusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_status, container, false)
        val recyclerRecentUpdates: RecyclerView = view.findViewById(R.id.recycler_recent_updates)
        val recyclerViewedUpdates: RecyclerView = view.findViewById(R.id.recycler_viewed_updates)
        val recyclerMutedUpdates: RecyclerView = view.findViewById(R.id.recycler_muted_updates)
        val statusAdapter = StatusAdapter()

        val status = Status("",Date(), User("","Mateus Mendes","", ""), ArrayList())
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)
        statusAdapter.statusList.add(status)

        recyclerRecentUpdates.isNestedScrollingEnabled = false
        recyclerViewedUpdates.isNestedScrollingEnabled = false
        recyclerMutedUpdates.isNestedScrollingEnabled = false

        recyclerRecentUpdates.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = statusAdapter
        }

        return view
    }
}
