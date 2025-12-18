package com.example.studenthobbyapp.model

import jakarta.persistence.*

@Entity
class Student(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String = "",

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_hobbies",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "hobby_id")]
    )
    var hobbies: Set<Hobby> = emptySet()
)