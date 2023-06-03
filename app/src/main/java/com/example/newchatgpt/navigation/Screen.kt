package com.example.newchatgpt.navigation

sealed class Screen(val route: String)
{
    object HomeScreen : Screen("home_screen")
    object ChatBot: Screen("chat_bot")
    object ChatHistory: Screen("chat_history")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach {arg->
                append("/$arg")

            }
        }
    }

}
