package com.example.week_3_assignment_cagrikirt.models.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_assignment_cagrikirt.R
import com.example.week_3_assignment_cagrikirt.models.datamodels.DogModel

class DogAdapter(val dogList: List<DogModel>, val onItemClicked: (DogModel) -> Unit) :
    RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dogName: TextView = itemView.findViewById(R.id.dog_name)
        private val personalityTV: TextView = itemView.findViewById(R.id.dog_personality)

        fun bind(word: String, personality: String) {
            dogName.text = word
            personalityTV.text = personality
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {

        //for navigating detail fragment
        holder.itemView.setOnClickListener {
            onItemClicked(dogList[position])
        }

        holder.bind(dogList[position].name, dogList[position].personality)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }


}