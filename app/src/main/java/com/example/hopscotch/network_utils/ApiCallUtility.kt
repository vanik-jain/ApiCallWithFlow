package com.example.hopscotch.network_utils

import android.util.Log
import com.example.hopscotch.model.state.ResponseState
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Created by vanikjain on 31/10/23
 */

inline fun <T : Any> apiCallWithCoroutine(crossinline block: suspend () -> T) = flow {
  emit(ResponseState.Loading)
  emit(ResponseState.Success(block()))
}.catch {
  emit(ResponseState.Error(it))
  Log.i("Error in calling api", it.message.toString())
}.cancellable()
