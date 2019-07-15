package com.mateusmendes.whatsappclone.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.User
import com.mateusmendes.whatsappclone.resIdByName
import com.mikhaellopez.circularimageview.CircularImageView

class ContactAdapter(
    private val context: Context,
    private val contactList: ArrayList<User>
): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    private var clickListener: ClickListener? = null

    inner class ContactHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
        val imageContact: CircularImageView = view.findViewById(R.id.imageContact)
        val textContactName: TextView = view.findViewById(R.id.textContactName)
        val textContactDescription: TextView = view.findViewById(R.id.textContactDescription)

        init {
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }

        override fun onClick(view: View) {
            clickListener!!.onItemClick(adapterPosition, view)
        }

        override fun onLongClick(view: View): Boolean {
            clickListener!!.onItemLongClick(adapterPosition, view)
            return false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)

        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = contactList[position]
        val res = context.resIdByName(contact.profilePicture, "drawable")

        holder.imageContact.setImageResource(res)
        holder.textContactName.text = contact.username
        holder.textContactDescription.text = contact.description
    }

    override fun getItemCount() = contactList.size

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    fun getItem(index: Int): User {
        return contactList[index]
    }

    interface ClickListener {
        fun onItemClick(index: Int, view: View)
        fun onItemLongClick(index: Int, view: View)
    }
}