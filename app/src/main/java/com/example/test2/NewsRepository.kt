package com.example.test2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository {

    suspend fun getNewsInfo(country : String,sources : String): List<NewsModel> {

        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(NewsApi::class.java)


        return api.getNewsData(Constants.API_KEY, country,sources).toNewsModel()
    }
}

fun NewsEntity.toNewsModel(): List<NewsModel> {
    return this.data.map{article ->
        NewsModel(
            title = article.title,
            description = article.description,
            source = article.source ,
            country = article.country
        )
    }
}

