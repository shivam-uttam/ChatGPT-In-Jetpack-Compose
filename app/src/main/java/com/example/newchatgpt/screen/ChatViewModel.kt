package com.example.newchatgpt.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newchatgpt.model.Message
import com.example.newchatgpt.model.OpenAIRequestBody
import com.example.newchatgpt.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor (private val apiService: ApiService) : ViewModel() {
    val messages = mutableStateListOf<Message>()

    fun sendMessage(text: String, isUser: Boolean = true) {
        messages.add(Message(text, "user"))
        if (isUser) {
            viewModelScope.launch {
                val response = ApiService.openAIApi.generateResponse(OpenAIRequestBody(messages = messages))
                messages.add(response.choices.first().message)
            }
        }
    }
}