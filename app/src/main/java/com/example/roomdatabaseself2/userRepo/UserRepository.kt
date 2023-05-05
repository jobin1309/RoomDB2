package com.example.roomdatabaseself2.userRepo


import androidx.lifecycle.LiveData
import com.example.roomdatabaseself2.data.UserDao
import com.example.roomdatabaseself2.model.User

class UserRepository(private val userDAO: UserDao) {


    val readAllData: LiveData<List<User>> = userDAO.readAll();


    suspend fun addUser(user: User) {
        userDAO.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDAO.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDAO.deleteUser(user)
    }

    fun deleteAll() {
        userDAO.deleteAll()
    }

    fun resetId() {
        userDAO.resetId()
    }


}