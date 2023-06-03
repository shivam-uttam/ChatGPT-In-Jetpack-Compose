package com.example.newchatgpt.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newchatgpt.database.ChatDao
import com.example.newchatgpt.database.ChatMessage
import com.example.newchatgpt.model.Message
import com.example.newchatgpt.model.OpenAIRequestBody
import com.example.newchatgpt.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val messages = mutableStateListOf<Message>()

    fun sendMessage(text: String, isUser: Boolean = true) {
        val message = Message(text, "user")

        messages.add(message)
        if (isUser) {
            viewModelScope.launch {
                val response = repository.generateResponse(OpenAIRequestBody(messages = messages))
                val generatedMessage = response.choices.first().message
                messages.add(generatedMessage)
                val chatEntity = ChatMessage(user_request = message.content, api_response = generatedMessage.content)
                withContext(Dispatchers.IO){
                    repository.insertMessage(chatEntity)
                }
            }
        }
    }
}
