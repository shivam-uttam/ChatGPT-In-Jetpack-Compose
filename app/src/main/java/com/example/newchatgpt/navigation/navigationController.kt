package com.example.newchatgpt.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newchatgpt.screen.ChatScreen
import com.example.newchatgpt.screen.ChatViewModel
import com.example.newchatgpt.screen.HomeScreen

@Composable
fun StartApp()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){

        composable(route = Screen.HomeScreen.route)
        {
            HomeScreen()
        }
        composable(route = Screen.ChatBot.route)
        {
            val chatViewModel = viewModel<ChatViewModel>()
            ChatScreen(chatViewModel)
        }


    }


}