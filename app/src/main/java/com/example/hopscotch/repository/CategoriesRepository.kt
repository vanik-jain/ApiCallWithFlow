package com.example.hopscotch.repository

import com.example.hopscotch.network.INetworkApi
import com.example.hopscotch.network_utils.RetrofitClient
import com.example.hopscotch.network_utils.apiCallWithCoroutine
import javax.inject.Inject

/**
 * Created by vanikjain on 31/10/23
 */

class CategoriesRepository @Inject constructor(private val iNetworkApi: INetworkApi) {

  suspend fun makeCategoriesApiCall() = apiCallWithCoroutine {
    iNetworkApi.getCategories()
  }

}