package com.example.newsapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.newsapp.modalclass.Article
import com.example.newsapp.R

class NewsDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_display)

        supportActionBar?.title = resources.getText(R.string.action_bar_second)
        val articles: Article? = intent.getParcelableExtra("articles")


        val fragImageView = findViewById<ImageView>(R.id.imageView2)
        val fragTitle = findViewById<TextView>(R.id.title2)
        val fragDescription = findViewById<TextView>(R.id.description2)

        Glide.with(this).load(articles?.urlToImage).into(fragImageView)
        fragTitle.text = articles?.title
        fragDescription.text = articles?.description
    }
}