package com.example.bt2_10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullName: TextView = itemView.findViewById(R.id.textViewFullName)
        val email: TextView = itemView.findViewById(R.id.textViewEmail)
        val phone: TextView = itemView.findViewById(R.id.textViewPhone)
        val gender: TextView = itemView.findViewById(R.id.textViewGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.fullName.text = user.fullName
        holder.email.text = user.email
        holder.phone.text = user.phone
        holder.gender.text = user.gender
    }

    override fun getItemCount() = userList.size
}
