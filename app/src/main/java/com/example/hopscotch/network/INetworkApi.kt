package com.example.hopscotch.network

import com.example.hopscotch.model.CategoryResponse
import retrofit2.http.GET

/**
 * Created by vanikjain on 31/10/23
 */

interface INetworkApi {
  @GET("/api/json/v1/1/categories.php") suspend fun getCategories(): CategoryResponse
}