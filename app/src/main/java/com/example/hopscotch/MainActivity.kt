package com.example.hopscotch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hopscotch.adapter.CategoryAdapter
import com.example.hopscotch.databinding.ActivityMainBinding
import com.example.hopscotch.model.CategoryResponse
import com.example.hopscotch.model.state.ResponseState
import com.example.hopscotch.view_model.CategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val categoriesViewModel: CategoriesViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    categoriesViewModel.callCategoriesApi()
    binding.pbHome.isVisible = false
    categoriesViewModel.categoryResponseData.observe(this) {
      when (it) {
        is ResponseState.Loading -> {
          binding.pbHome.isVisible = true
        }

        is ResponseState.Success<CategoryResponse> -> {
          binding.pbHome.isVisible = false
          initRecyclerView(it.data)
        }

        is ResponseState.Error -> {
          binding.pbHome.isVisible = false
          Toast.makeText(this, "ERROR in fetching data ${it.throwable.localizedMessage}", Toast.LENGTH_LONG).show()
        }

        else -> { // not implementation required
        }
      }
    }
  }

  private fun initRecyclerView(categoryResponse: CategoryResponse) {
    with(binding.rvCategories) {
      categoryResponse.categories?.let {
        isVisible = true
        layoutManager = LinearLayoutManager(context)
        adapter = CategoryAdapter(it)
      } ?: kotlin.run {
        isVisible = false
      }
    }
  }
}