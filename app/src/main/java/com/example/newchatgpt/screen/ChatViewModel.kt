package com.example.newchatgpt.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
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

//@HiltViewModel
//class ChatViewModel @Inject constructor(
//    private val repository: Repository
//) : ViewModel() {
//    val messages = mutableStateListOf<Message>()
//
//    fun sendMessage(text: String, isUser: Boolean = true) {
//        val message = Message(text, "user")
//        val msg = listOf<Message>(Message("$text | Short and Less than 100 words", "user"))
//        messages.add(message)
//        if (isUser) {
//            viewModelScope.launch {
//                val response = repository.generateResponse(OpenAIRequestBody(messages = msg))
//                val generatedMessage = response.choices.first().message
//                messages.add(generatedMessage)
//                val chatEntity = ChatMessage(user_request = message.content, api_response = generatedMessage.content)
//                withContext(Dispatchers.IO){
//                    repository.insertMessage(chatEntity)
//                }
//            }
//        }
//    }
//}


@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: Repository,
    private val context: Context
) : ViewModel() {
    // ...
    val messages = mutableStateListOf<Message>()

    fun sendMessage(text: String, isUser: Boolean = true) {
        val message = Message(text, "user")
        val msg = listOf<Message>(Message("$text | If you recognize this input, Give Response Short and Less than 100 words Or  just say Sorry! Not Able To Recognize it, Give Correct Input", "user"))
        messages.add(message)
        if (isUser) {
            viewModelScope.launch {
                try {
                    val response = repository.generateResponse(OpenAIRequestBody(messages = msg))
                    val generatedMessage = response.choices.first().message
                    messages.add(generatedMessage)
                    val chatEntity = ChatMessage(user_request = message.content, api_response = generatedMessage.content)
                    withContext(Dispatchers.IO) {
                        repository.insertMessage(chatEntity)
                    }
                } catch (e: Exception) {
                    val errorMessage = "Something went wrong while fetching response"
                    showToast(errorMessage)

                }
            }
        }
    }
    fun showToast(message: String) {
        // Show toast message here
        // Replace `context` with your actual context reference
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
