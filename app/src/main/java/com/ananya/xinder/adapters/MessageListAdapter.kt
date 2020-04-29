package com.ananya.xinder.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thecode.tinderclone.R
import com.ananya.xinder.activities.TinderCloneMainActivity
import com.ananya.xinder.entities.MessageItem
import kotlinx.android.synthetic.main.adapter_message_item.view.*

class MessageListAdapter(private val context: Context, private val messageList: List<MessageItem>,val tinderCloneMainActivity: TinderCloneMainActivity) : RecyclerView.Adapter<MessageListAdapter.MyViewHolder>() {

     class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var content: TextView
        var count: TextView? = null
        var thumbnail: ImageView
        var viewIndicator: RelativeLayout

        init {
            name = view.findViewById(R.id.text_name)
            content = view.findViewById(R.id.text_content)
            thumbnail = view.findViewById(R.id.thumbnail)
            viewIndicator = view.findViewById(R.id.layout_dot_indicator)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_message_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = messageList[position]
        holder.name.text = item.name
        holder.content.text = item.content
        if (item.count <= 0) {
            holder.viewIndicator.visibility = View.INVISIBLE
        }
        Glide.with(context)
                .load(item.picture)
                .into(holder.thumbnail)
        listOf(holder.thumbnail,holder.content,holder.name,holder.view.layout_message_content).forEach {
            it.setOnClickListener {
                tinderCloneMainActivity.changePage(3)
            }
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

}