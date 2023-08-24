package com.example.newsapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        val authorTextView = findViewById<TextView>(R.id.authorTextView)

        articles?.urlToImage?.let {
            Glide.with(this).load(it).into(fragImageView)
        }
        fragTitle.text = articles?.title ?: "NA"
        fragDescription.text = articles?.description ?: "NA"
        authorTextView.text = articles?.let{
            resources.getString(R.string.author,articles.author)
        } ?: "NA"

    }
}