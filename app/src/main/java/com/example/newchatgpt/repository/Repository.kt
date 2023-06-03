package com.example.newchatgpt.repository

import com.example.newchatgpt.model.OpenAIRequestBody
import com.example.newchatgpt.model.OpenAIResponse
import com.example.newchatgpt.network.OpenAIApi
import javax.inject.Inject


class Repository @Inject constructor(private val openAIApi: OpenAIApi) {
    suspend fun generateResponse(requestBody: OpenAIRequestBody): OpenAIResponse {
        return openAIApi.generateResponse(requestBody)
    }
}
