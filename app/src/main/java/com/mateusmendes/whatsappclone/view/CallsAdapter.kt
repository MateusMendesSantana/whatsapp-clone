package com.mateusmendes.whatsappclone.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.mateusmendes.whatsappclone.R
import com.mateusmendes.whatsappclone.model.Call
import com.mikhaellopez.circularimageview.CircularImageView
import java.text.SimpleDateFormat

class CallsAdapter(
    private val userId: String,
    private val callList: ArrayList<Call>
): RecyclerView.Adapter<CallsAdapter.CallHolder>() {
    private var clickListener: ClickListener? = null

    inner class CallHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
        val imageContact: CircularImageView = view.findViewById(R.id.imageContact)
        val textUsername: TextView = view.findViewById(R.id.textUsername)
        val textDate: TextView = view.findViewById(R.id.textDate)
        val buttonCall: ImageButton = view.findViewById(R.id.buttonCall)
        val imageArrowRed: ImageView = view.findViewById(R.id.imageArrowRed)
        val imageArrowGreen: ImageView = view.findViewById(R.id.imageArrowGreen)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.call_item, parent, false)

        return CallHolder(view)
    }

    override fun onBindViewHolder(holder: CallHolder, position: Int) {
        val call = callList[position]
        val format = SimpleDateFormat("MMMM dd, hh:mm a")
        val isOwner = call.ownerId == userId

        holder.textUsername.text = call.participants!!.filter { it.id != userId }.joinToString(", ") { it.username }
        holder.imageArrowRed.visibility = if (isOwner) View.GONE else View.VISIBLE
        holder.imageArrowGreen.visibility = if (isOwner) View.VISIBLE else View.GONE
        holder.textDate.text = format.format(call.createdAt)
    }

    override fun getItemCount() = callList.size

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    fun getItem(index: Int): Call {
        return callList[index]
    }

    interface ClickListener {
        fun onItemClick(index: Int, view: View)
        fun onItemLongClick(index: Int, view: View)
    }
}