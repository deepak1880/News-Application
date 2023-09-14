package com.example.newsapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.interfaceclass.NewService
import com.example.newsapp.modalclass.News
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()
        supportActionBar?.title = resources.getText(R.string.action_bar_name)
    }

    private fun getNews() {

        val news = NewService.newIntance.getHeadline("in", 1)
        news.enqueue(object : retrofit2.Callback<News> {

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null) {
                    Log.d("Test-1", NewService.toString())

                    val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                    adapter = NewsAdapter(this@MainActivity, news.articles)
                    adapter.itemOnClick = {
                        val intent = Intent(this@MainActivity, NewsDisplayActivity::class.java)
                        intent.putExtra("articles", it)
                        startActivity(intent)
                    }
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("onFailure", "Error in Fetching news")
            }
        })
    }
}