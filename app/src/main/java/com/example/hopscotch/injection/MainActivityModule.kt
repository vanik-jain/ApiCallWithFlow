package com.example.hopscotch.injection

import com.example.hopscotch.network.INetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

/**
 * Created by vanikjain on 31/10/23
 */

@Module @InstallIn(ActivityComponent::class) class MainActivityModule {
  @Provides @ViewModelScoped fun providesCategoriesApi(retrofit: Retrofit): INetworkApi =
    retrofit.create(INetworkApi::class.java)
}