package com.example.newchatgpt.di

import com.example.newchatgpt.network.ApiService
import com.example.newchatgpt.screen.ChatViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiServices(): ApiService{
        return ApiService
    }
    @Provides
    fun provideChatViewModel(apiService: ApiService): ChatViewModel{
        return ChatViewModel(apiService)
    }
}