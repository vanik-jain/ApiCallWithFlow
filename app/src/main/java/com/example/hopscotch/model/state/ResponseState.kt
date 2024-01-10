package com.example.hopscotch.model.state

sealed class ResponseState<out R> {

  object Empty : ResponseState<Nothing>()

  object Loading : ResponseState<Nothing>()

  class Success<T : Any>(val data: T) : ResponseState<T>()

  class Error(val throwable: Throwable) : ResponseState<Nothing>()
}
