import com.example.studenthobbyapp.model.Hobby
import com.example.studenthobbyapp.model.Student
import com.example.studenthobbyapp.repository.HobbyRepository
import com.example.studenthobbyapp.repository.StudentRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataSeeder(
    private val studentRepository: StudentRepository,
    private val hobbyRepository: HobbyRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        // Создаем и сохраняем список доступных хобби
        val hobby1 = hobbyRepository.save(Hobby(name = "Reading"))
        val hobby2 = hobbyRepository.save(Hobby(name = "Swimming"))
        val hobby3 = hobbyRepository.save(Hobby(name = "Gaming"))
        val hobby4 = hobbyRepository.save(Hobby(name = "Cooking"))

        // Создаем тестового студента с набором хобби
        val student = Student(
            name = "Ivan Ivanov",
            hobbies = setOf(hobby1, hobby3)
        )
        studentRepository.save(student)

        println("DataSeeder: База данных успешно заполнена начальными хобби!")
    }
}