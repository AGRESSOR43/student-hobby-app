package com.example.studenthobbyapp

// Этот объект будет летать между сервисами через Kafka
data class UserDto(
    val name: String = "",
    var hobby: String = ""
)