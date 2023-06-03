package com.example.newchatgpt.network

import com.example.newchatgpt.model.OpenAIRequestBody
import com.example.newchatgpt.model.OpenAIResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface OpenAIApi {
    @Headers("Content-Type: application/json", "Authorization: Bearer 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")
    @POST("v1/chat/completions")
    suspend fun generateResponse(@Body requestBody: OpenAIRequestBody): OpenAIResponse
}