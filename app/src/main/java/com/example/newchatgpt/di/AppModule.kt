package com.example.newchatgpt.di

import com.example.newchatgpt.network.OpenAIApi
import com.example.newchatgpt.repository.Repository
import com.example.newchatgpt.screen.ChatViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiServices(): OpenAIApi {
        return Retrofit.Builder()
            .baseUrl("https://api.openai.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenAIApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepository(apiService: OpenAIApi): Repository {
        return Repository(apiService)
    }

    @Provides
    fun provideChatViewModel(repository: Repository): ChatViewModel {
        return ChatViewModel(repository)
    }
}