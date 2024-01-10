package com.example.hopscotch.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.hopscotch.model.CategoryResponse
import com.example.hopscotch.model.state.ResponseState
import com.example.hopscotch.repository.CategoriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by vanikjain on 31/10/23
 */

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val repository: CategoriesRepository) :
  ViewModel() {

  private val _categoryResultDataState by lazy {
    MutableStateFlow<ResponseState<CategoryResponse>>(ResponseState.Empty)
  }
  val categoryResponseData = _categoryResultDataState.asLiveData()

  fun callCategoriesApi() {
   viewModelScope.launch {
      repository.makeCategoriesApiCall().collect {
        _categoryResultDataState.emit(it)
      }
    }
  }

}