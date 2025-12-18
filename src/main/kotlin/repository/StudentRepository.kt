package com.example.studenthobbyapp.repository

import com.example.studenthobbyapp.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long>