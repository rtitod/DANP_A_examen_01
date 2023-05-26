package com.example.examen1.database.model

import com.example.examen1.database.entities.User

class Worker (private val MyAppDatabase: MyAppDatabase) {
    suspend fun insert(User: User) {
        MyAppDatabase.userDao().insert(User)
    }
    suspend fun getAll(): List<User> {
        return MyAppDatabase.userDao().getAllUsers()
    }
}