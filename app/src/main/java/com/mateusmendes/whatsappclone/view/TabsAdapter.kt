package com.mateusmendes.whatsappclone.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabsAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    private val fragments = ArrayList<Fragment>()

    init {
        fragments.add(ChatsFragment())
        fragments.add(ChatsFragment())
        fragments.add(StatusFragment())
        fragments.add(CallsFragment())
    }

    override fun getItem(position: Int): Fragment {
        return this.fragments[position]
    }

    override fun getCount(): Int {
        return this.fragments.size
    }
}