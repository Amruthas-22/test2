package com.example.test2

import android.os.Bundle
import android.view.View

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityTwo : ComponentActivity(), RecyclerViewAdapter.ItemClickListener{
    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        mRecyclerView = findViewById(R.id.recyclerview)


        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ActivityTwo, RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

        val extra= intent.extras
        val source= extra?.getString("source").toString()
        val country= extra?.getString("country").toString()
        viewModel.newsDetails.observe(this) {
            mAdapter.updateData(it)
        }


        fetchNewsDetails(country, source)

        viewModel.newsDetails.observe(this) { newsList ->
            mAdapter.updateData(newsList)
        }
    }

    private fun fetchNewsDetails(country: String, source: String) {
        viewModel.getNewsDetails(country,source)
    }

    override fun onItemClick(view: View?, position: Int) {
    }
}



