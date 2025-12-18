package com.example.studenthobbyapp

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class HobbyProcessor(private val kafkaTemplate: KafkaTemplate<String, Any>) {

    private val randomHobbies = listOf("Reading", "Sports", "Gaming", "Traveling", "Cooking", "Music")

    @KafkaListener(topics = ["user-input"], groupId = "processor-group")
    fun process(user: UserDto) {
        println("Processor: Получен пользователь ${user.name}, меняем хобби...")

        user.hobby = randomHobbies.random()
        kafkaTemplate.send("user-output", user)
    }
}