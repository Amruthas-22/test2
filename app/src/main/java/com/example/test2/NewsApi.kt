package com.example.test2

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news")
    suspend fun getNewsData(
        @Query("access_key") apiKey: String = Constants.API_KEY,
        @Query("countries") countries: String ,
       @Query("sources") sources: String
    ): NewsEntity

}
