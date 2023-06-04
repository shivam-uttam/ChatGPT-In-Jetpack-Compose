package com.example.newchatgpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newchatgpt.screen.ChatScreen
import com.example.newchatgpt.screen.ChatViewModel
import com.example.newchatgpt.ui.theme.NewChatGptTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewChatGptTheme {
//                val chatViewModel = viewModel<ChatViewModel>()
//                val chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java) // For activity
//// or
                val chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java) // For fragment

                ChatScreen(chatViewModel)

            }
        }
    }
}
