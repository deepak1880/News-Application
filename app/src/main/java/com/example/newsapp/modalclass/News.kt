package com.example.newsapp.modalclass

import android.os.Parcelable
import com.example.newsapp.modalclass.Article
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(val totalResults:Int,val articles:List<Article>) : Parcelable {
}