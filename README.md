Технологии
Language: Kotlin 1.9.20

Framework: Spring Boot 3.2.0

Broker: Apache Kafka

Database: PostgreSQL

Containerization: Docker
как запустить проект
1. Запуск инфраструктуры
Перед запуском приложений необходимо поднять базу данных и брокер сообщений. В терминале (в корне проекта) выполните:

Bash

docker-compose up -d
Использование
Перейдите на http://localhost:8080/students.

Добавьте студента и его хобби через форму.

Данные отправятся в Kafka, обработаются вторым сервисом и вернутся обновленными в таблицу.
