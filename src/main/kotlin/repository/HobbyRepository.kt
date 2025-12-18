package com.example.studenthobbyapp.repository

import com.example.studenthobbyapp.model.Hobby
import org.springframework.data.jpa.repository.JpaRepository

interface HobbyRepository : JpaRepository<Hobby, Long> {
    fun findByNameIgnoreCase(name: String): Hobby?
}