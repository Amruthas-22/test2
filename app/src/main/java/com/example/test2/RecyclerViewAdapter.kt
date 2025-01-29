package com.example.test2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(mainActivity: MainActivity) : RecyclerView.Adapter<RecycleViewHolder>() {

    private var mClickListener: ItemClickListener = mainActivity

    private var newsModelList = listOf<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.recyclerview_row, parent, false)
        return RecycleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        Log.e("Adapter position", position.toString())

        val newsModel = newsModelList[position]
        holder.textViewTitle.text = newsModel.title
        holder.textViewDescription.text = newsModel.description
        holder.textViewSource.text = newsModel.source
    }

    override fun getItemCount(): Int {
        return newsModelList.size
    }

    fun updateData(newsModel: List<NewsModel>) {
        newsModelList = newsModel
        notifyDataSetChanged()
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }
}