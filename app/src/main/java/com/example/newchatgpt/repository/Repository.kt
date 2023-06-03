package com.example.newchatgpt.repository

import com.example.newchatgpt.database.ChatDao
import com.example.newchatgpt.database.ChatDatabase
import com.example.newchatgpt.database.ChatMessage
import com.example.newchatgpt.model.OpenAIRequestBody
import com.example.newchatgpt.model.OpenAIResponse
import com.example.newchatgpt.network.OpenAIApi
import javax.inject.Inject


class Repository @Inject constructor(
    private val openAIApi: OpenAIApi,
    private val chatDao: ChatDao
) {
    suspend fun generateResponse(requestBody: OpenAIRequestBody): OpenAIResponse {
        return openAIApi.generateResponse(requestBody)
    }

    suspend fun insertMessage(message: ChatMessage) = chatDao.insertMessage(message)



}
