package com.example.roomdatabaseself2.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabaseself2.adapter.UserAdapter
import com.example.roomdatabaseself2.model.User
import com.example.roomdatabaseself2.viewModel.UserViewModel
import com.example.roomdb.R
import com.example.roomdb.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ListFragment: Fragment() {

    private lateinit var binding: FragmentListBinding;

    private val viewModel: UserViewModel by viewModels()
    private lateinit var mAdapter: UserAdapter;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        mAdapter = UserAdapter(viewModel);
        binding.recyclerView.adapter = mAdapter;
        binding.recyclerView.layoutManager = LinearLayoutManager(context);

        setHasOptionsMenu(true);
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        viewModel.readAllData.observe(viewLifecycleOwner) { user ->
            mAdapter.setUser(user);
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAllUsers()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers() {
        val builder = AlertDialog.Builder(context)

        builder.setTitle("Delete Everything")
        builder.setMessage("Are you sure you want to delete everything!")

        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteAll()
            viewModel.resetId()

            Toast.makeText(context, "Removed Everything", Toast.LENGTH_LONG).show()

        }

        builder.setNegativeButton("NO") { _, _ -> }
        builder.create().show();

    }


}