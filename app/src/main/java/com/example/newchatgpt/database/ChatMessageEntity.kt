package com.example.newchatgpt.database

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "chat_messages")
data class ChatMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val user_request: String,
    val api_response: String
)
