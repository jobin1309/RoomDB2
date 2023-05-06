package com.example.roomdatabaseself2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

import com.example.roomdatabaseself2.model.User
import com.example.roomdatabaseself2.ui.ListFragmentDirections
import com.example.roomdatabaseself2.viewModel.UserViewModel
import com.example.roomdb.R

class UserAdapter(private var viewModel: UserViewModel) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var list = emptyList<User>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val deleteBtn: ImageView = itemView.findViewById<ImageView>(R.id.deleteBtn);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var item = list[position];

        holder.itemView.findViewById<TextView>(R.id.id).text = item.id.toString();
        holder.itemView.findViewById<TextView>(R.id.Name_tv).text = item.name
        holder.itemView.findViewById<TextView>(R.id.age_tv).text = item.age.toString();
        holder.itemView.findViewById<TextView>(R.id.profession_tv).text = item.profession


        holder.deleteBtn.setOnClickListener {
            deleteUser(item)
        }




        holder.itemView.findViewById<ConstraintLayout>(R.id.row_layout).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(item)
            holder.itemView.findNavController().navigate(action)
        }

    }

    private fun deleteUser(item: User) {
        viewModel.deleteUser(item)

    }

    fun setUser(user: List<User>) {
        this.list = user
        notifyDataSetChanged()
    }


}