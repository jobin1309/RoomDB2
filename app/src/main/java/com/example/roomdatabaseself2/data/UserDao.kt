package com.example.roomdatabaseself2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabaseself2.model.User


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
     fun deleteAll()

    @Query("DELETE FROM sqlite_sequence WHERE NAME='user_table'")
     fun resetId();


    @Query("SELECT * FROM user_table")
     fun readAll(): LiveData<List<User>>



}