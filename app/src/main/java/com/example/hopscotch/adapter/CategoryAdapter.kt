package com.example.hopscotch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hopscotch.databinding.ItemCategoryBinding
import com.example.hopscotch.loadImage
import com.example.hopscotch.model.CategoriesItem

/**
 * Created by vanikjain on 31/10/23
 */

class CategoryAdapter(private val list: List<CategoriesItem>) :
  RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
    CategoryViewHolder(
      ItemCategoryBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
      )
    )

  override fun getItemCount(): Int = list.size

  override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = holder.bind(position)

  inner class CategoryViewHolder(private val itemCategoryBinding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(itemCategoryBinding.root) {
    fun bind(position: Int) {
      with(itemCategoryBinding) {
        list.getOrNull(position)?.let {
          tvTitle.text = it.strCategory.orEmpty()
          tvDescription.text = it.strCategoryDescription.orEmpty()
          loadImage(it.strCategoryThumb.orEmpty(), ivCategory)
        }
      }
    }
  }

}