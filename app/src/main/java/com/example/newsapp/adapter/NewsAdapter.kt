package com.example.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.modalclass.Article
import com.example.newsapp.R

class NewsAdapter(val context: Context, val articles: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    var itemOnClick: ((Article) -> Unit)? = null

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var newimage = itemView.findViewById<ImageView>(R.id.image)
        var newtitle = itemView.findViewById<TextView>(R.id.title)
        var newdescription = itemView.findViewById<TextView>(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardviewlayout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.newtitle.text = article.title
        holder.newdescription.text = article.description

        holder.itemView.setOnClickListener {
            itemOnClick?.invoke(article)
        }
        Glide.with(context).load(article.urlToImage).into(holder.newimage)

    }
}
