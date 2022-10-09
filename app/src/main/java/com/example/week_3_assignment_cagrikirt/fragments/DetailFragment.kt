package com.example.week_3_assignment_cagrikirt.fragments

import android.R.attr.defaultValue
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_assignment_cagrikirt.R
import com.example.week_3_assignment_cagrikirt.models.datamodels.DogModel


class DetailFragment : Fragment() {

    var dogModel:DogModel= DogModel("","")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = this.arguments
        if (bundle != null) {
            dogModel.name = bundle.getString("dogName","")
            dogModel.personality = bundle.getString("personality","")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_detail, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.dog_name_txt).text=dogModel.name
       view.findViewById<TextView>(R.id.dog_personality_txt).text=dogModel.personality
    }

}