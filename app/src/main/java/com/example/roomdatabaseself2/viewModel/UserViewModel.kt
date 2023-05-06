package com.example.roomdatabaseself2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.roomdatabaseself2.data.UserDatabase
import com.example.roomdatabaseself2.model.User
import com.example.roomdatabaseself2.userRepo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(private val mRepository: UserRepository) : ViewModel() {


    val readAllData: LiveData<List<User>> = mRepository.readAllData


    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.addUser(user)

        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.updateUser(user)

        }
    }



    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.deleteUser(user)

        }

    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.deleteAll()

        }
    }


    fun resetId() {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.resetId()

        }
    }


}

