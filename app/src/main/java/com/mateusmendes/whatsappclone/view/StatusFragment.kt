package com.mateusmendes.whatsappclone.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.dto.StatusDTO
import com.mateusmendes.whatsappclone.presenter.StatusPresenter
import com.mateusmendes.whatsappclone.presenter.StatusPresenterInterface

class StatusFragment : Fragment() {
    private lateinit var statusPresenter: StatusPresenterInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_status, container, false)
        val recyclerRecentUpdates: RecyclerView = view.findViewById(R.id.recycler_recent_updates)
        val recyclerViewedUpdates: RecyclerView = view.findViewById(R.id.recycler_viewed_updates)
        val recyclerMutedUpdates: RecyclerView = view.findViewById(R.id.recycler_muted_updates)

        statusPresenter = StatusPresenter(resources)
        val statusDTOList = statusPresenter.loadAll()
        val recentStatus = statusDTOList.filter { it.hasNewStatus() } as ArrayList
        val viewedStatus = statusDTOList.filter { !it.hasNewStatus() } as ArrayList

        configureRecyclerView(recyclerRecentUpdates, recentStatus)
        configureRecyclerView(recyclerViewedUpdates, viewedStatus)
        configureRecyclerView(recyclerMutedUpdates, ArrayList())

        return view
    }

    private fun configureRecyclerView(recyclerView: RecyclerView, statusList: ArrayList<StatusDTO>) {
        val statusAdapter = StatusAdapter(statusList)

        recyclerView.isNestedScrollingEnabled = false
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = statusAdapter
        }
    }
}
