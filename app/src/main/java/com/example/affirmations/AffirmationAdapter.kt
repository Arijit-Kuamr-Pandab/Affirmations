package com.example.affirmations.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.affirmations.R

class affirmationAdapter(private val context:Context,private val list: List<Affirmation>): RecyclerView.Adapter<affirmationAdapter.viewHolder>() {
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Text: TextView = itemView.findViewById(R.id.affirmation_text)
        val image: ImageView = itemView.findViewById(R.id.affirmation_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.Text.text = context.resources.getString(list[position].stringId)
        Glide.with(holder.itemView.context).load(list[position].imageId).placeholder(R.drawable.ic_launcher_background).into(holder.image)
        holder.itemView.setOnClickListener {
            Toast.makeText(context,context.resources.getString(list[position].stringId),Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}