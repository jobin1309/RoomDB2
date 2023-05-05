package com.example.roomdatabaseself2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.roomdatabaseself2.model.User
import com.example.roomdatabaseself2.viewModel.UserViewModel
import com.example.roomdb.R
import com.example.roomdb.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding;
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.addBtn.setOnClickListener {
            insertData()
        }

    }

    private fun insertData() {
        val name = binding.editTexttPersonName.text.toString()
        val age = binding.editTextAge.text.toString()?.toIntOrNull()
        val profession = binding.editTextTextProfession.text.toString()

        if (name.isNotEmpty() && age != null && profession.isNotEmpty()) {
            val user = User(0, name, age, profession)
            viewModel.addUser(user)

            Toast.makeText(context, "User Added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }
        else {
            Toast.makeText(context, "Failed Try again", Toast.LENGTH_LONG).show()
        }

    }


}