package com.example.newchatgpt.di

import android.content.Context
import androidx.room.Room
import com.example.newchatgpt.database.ChatDao
import com.example.newchatgpt.database.ChatDatabase
import com.example.newchatgpt.network.OpenAIApi
import com.example.newchatgpt.repository.Repository
import com.example.newchatgpt.screen.ChatViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideRepository(apiService: OpenAIApi, chatDao: ChatDao): Repository {
        return Repository(apiService,chatDao)
    }

    @Provides
    fun provideChatViewModel(repository: Repository, @ApplicationContext context: Context): ChatViewModel {
        return ChatViewModel(repository, context)
    }

    @Singleton
    @Provides
    fun providesChatDao(chatDatabase: ChatDatabase): ChatDao{
        return chatDatabase.ChatDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ChatDatabase{
        return Room.databaseBuilder(context = context, ChatDatabase::class.java, "chat_db")
            .fallbackToDestructiveMigration().build()
    }





}