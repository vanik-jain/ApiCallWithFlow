package com.example.hopscotch.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

	@field:SerializedName("categories")
	val categories: List<CategoriesItem>? = null
)