package com.example.roomdatabaseself2.di

import android.content.Context
import android.service.autofill.UserData
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roomdatabaseself2.data.UserDao
import com.example.roomdatabaseself2.data.UserDatabase
import com.example.roomdatabaseself2.userRepo.UserRepository
import com.example.roomdatabaseself2.viewModel.UserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module //class provides dependencies
@InstallIn(SingletonComponent::class) //scope of the the dependencies
object RoomModule {

    @Provides
    fun ProvideUserDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(context, UserDatabase::class.java, "User_database")
            .fallbackToDestructiveMigration().build()
    }
    @Provides
    fun ProvideUserDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.userDao();
    }

    @Provides
    fun provideViewModel(fragment: Fragment, mRepository: UserRepository) : ViewModel{
       return ViewModelProvider(fragment)[UserViewModel::class.java]
    }
}