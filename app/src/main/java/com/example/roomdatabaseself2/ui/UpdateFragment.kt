package com.example.roomdatabaseself2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomdatabaseself2.model.User
import com.example.roomdatabaseself2.viewModel.UserViewModel
import com.example.roomdb.R
import com.example.roomdb.databinding.FragmentUpdateBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class UpdateFragment(): Fragment() {

    private lateinit var binding: FragmentUpdateBinding;
    private val args by navArgs<UpdateFragmentArgs>()
    private val viewModel: UserViewModel by viewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentUpdateBinding.inflate(inflater, container, false);
        binding.editTexttPersonName.setText(args.userData.name);
        binding.editTextAge.setText(args.userData.age.toString())
        binding.editTextTextProfession.setText(args.userData.profession);
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.updateBtn.setOnClickListener {
            updateUser()
        }
    }

    private fun updateUser() {

        val editName = binding.editTexttPersonName.text.toString()
        val editAge = binding.editTextAge.text.toString().toIntOrNull()
        val editProfession = binding.editTextTextProfession.text.toString()

        if (editName.isNotEmpty() && editAge != null && editProfession.isNotEmpty()) {

            val user = User(args.userData.id, editName, editAge, editProfession)
            viewModel.updateUser(user)

            findNavController().navigate(R.id.action_updateFragment_to_listFragment);
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_LONG).show()
        }

    }


}