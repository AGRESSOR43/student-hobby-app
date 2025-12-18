package com.example.studenthobbyapp.model

import jakarta.persistence.*

@Entity
class Hobby(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = ""
)