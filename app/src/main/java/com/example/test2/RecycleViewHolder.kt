package com.example.test2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var textViewTitle: TextView = itemView.findViewById(R.id.title)
    var textViewDescription: TextView = itemView.findViewById(R.id.description)
    var textViewSource: TextView = itemView.findViewById(R.id.source)



}