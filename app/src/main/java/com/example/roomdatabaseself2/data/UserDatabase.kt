package com.example.roomdatabaseself2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabaseself2.model.User
import dagger.hilt.android.qualifiers.ApplicationContext


@Database(entities = [User::class],version = 1,exportSchema = false )
abstract class UserDatabase : RoomDatabase() {


    abstract fun userDao(): UserDao;

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null;


        fun getDatabase(context: Context): UserDatabase {
            var tempInstace = INSTANCE
            if (tempInstace != null) {
                return tempInstace
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    UserDatabase::class.java,
                    "user_database",
                    ).fallbackToDestructiveMigration().build()
                INSTANCE = instance;
                return instance;

            }

        }


    }

}