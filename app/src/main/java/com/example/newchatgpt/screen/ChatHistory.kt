package com.example.newchatgpt.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen()
{
    Surface(modifier = Modifier.fillMaxSize())
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(30.dp))
        {
            Button(onClick = { /*TODO*/ })
            {
                Text(text = "ChatBot")
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "ChatHistory")

            }

        }

    }
}