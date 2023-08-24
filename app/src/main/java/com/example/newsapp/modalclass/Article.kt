package com.example.newsapp.modalclass

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
) :
    Parcelable {
}