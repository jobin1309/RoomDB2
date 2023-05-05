package com.example.roomdatabaseself2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabaseself2.adapter.UserAdapter
import com.example.roomdatabaseself2.data.UserDatabase
import com.example.roomdatabaseself2.model.User
import com.example.roomdatabaseself2.userRepo.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {


    val readAllData: LiveData<List<User>>
    private var mRepository: UserRepository;


    init {
        var userDao = UserDatabase.getDatabase(application).userDao()
        mRepository = UserRepository(userDao);
        readAllData = mRepository.readAllData

    }


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

