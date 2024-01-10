package com.example.hopscotch.network_utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by vanikjain on 31/10/23
 */

object RetrofitClient {

  const val BASE_URL = "https://www.themealdb.com/api/json/"

  val retrofitClient by lazy {
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
  }

}