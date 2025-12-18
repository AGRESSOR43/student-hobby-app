package com.example.studenthobbyapp.controller

import com.example.studenthobbyapp.model.Student
import com.example.studenthobbyapp.model.Hobby
import com.example.studenthobbyapp.repository.HobbyRepository
import com.example.studenthobbyapp.service.StudentService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/students")
class StudentWebController(
    private val studentService: StudentService,
    private val hobbyRepository: HobbyRepository
) {

    @GetMapping
    fun listStudents(
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) hobby: String?,
        model: Model
    ): String {
        var students = studentService.getAllStudents()

        // Фильтрация
        if (!name.isNullOrBlank()) {
            students = students.filter { it.name.contains(name, ignoreCase = true) }
        }
        if (!hobby.isNullOrBlank()) {
            students = students.filter { s -> s.hobbies.any { it.name.equals(hobby, ignoreCase = true) } }
        }

        model.addAttribute("students", students)
        // Список имен хобби для выпадающего списка в фильтре
        model.addAttribute("allHobbies", hobbyRepository.findAll().map { it.name }.distinct())
        return "student-list"
    }

    @PostMapping("/add")
    fun addStudent(
        @RequestParam name: String,
        @RequestParam(name = "hobbies", required = false) hobbyNames: List<String>?
    ): String {
        // Обработка текстовых полей хобби
        val selectedHobbies = hobbyNames?.filter { it.isNotBlank() }?.map { hobbyName ->
            // Ищем хобби в БД, если нет — создаем новое
            hobbyRepository.findByNameIgnoreCase(hobbyName.trim())
                ?: hobbyRepository.save(Hobby(name = hobbyName.trim()))
        }?.toSet() ?: emptySet()

        val student = Student(name = name, hobbies = selectedHobbies)
        studentService.saveStudent(student)

        return "redirect:/students"
    }
}