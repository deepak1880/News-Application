package com.example.newsapp.interfaceclass

import com.example.newsapp.modalclass.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=API_KEY
//https://newsapi.org/v2/everything?q=tesla&from=2023-07-14&sortBy=publishedAt&apiKey=API_KEY

const val API_KEY = "b2b4977236414666b636050a1e48dacf"
const val BASE_URL = "https://newsapi.org/"

interface NewsInterface {

    @GET("v2/top-headlines?country=in&category=business&apiKey=$API_KEY")
        fun getHeadline(@Query("country") country: String, @Query("page") page: Int): Call<News>
}

object NewService {
    val newIntance: NewsInterface
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newIntance = retrofit.create(NewsInterface::class.java)
    }
}
