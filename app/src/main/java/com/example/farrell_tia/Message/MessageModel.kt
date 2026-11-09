package com.example.farrell_tia.Message

// Data satu pesan: nama pengirim, isi pesan, dan link foto profil
data class MessageModel(
    val senderName: String,
    val messageText: String,
    val avatarUrl: String
)
