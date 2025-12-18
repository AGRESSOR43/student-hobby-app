package com.example.studenthobbyapp.service

import com.example.studenthobbyapp.model.Student
import com.example.studenthobbyapp.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository) {

    // Получить всех студентов для списка
    fun getAllStudents(): List<Student> = studentRepository.findAll()

    // Найти одного студента по ID (нужно для редактирования)
    fun getStudentById(id: Long): Student? = studentRepository.findById(id).orElse(null)

    // Сохранить или обновить студента
    fun saveStudent(student: Student): Student = studentRepository.save(student)

    // Удалить студента
    fun deleteStudent(id: Long) = studentRepository.deleteById(id)
}