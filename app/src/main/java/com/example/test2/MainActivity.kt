package com.example.test2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : ComponentActivity(), RecyclerViewAdapter.ItemClickListener {

    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)

    private lateinit var countryEditText: EditText
    private lateinit var sourceEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val button = findViewById<Button>(R.id.button)
        countryEditText = findViewById(R.id.country)
        sourceEditText = findViewById(R.id.source)
        mRecyclerView = findViewById(R.id.recyclerview)


        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

        button.setOnClickListener {
            val country = countryEditText.text.toString()
            val source = sourceEditText.text.toString()


            fetchNewsDetails(country, source)
        }

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