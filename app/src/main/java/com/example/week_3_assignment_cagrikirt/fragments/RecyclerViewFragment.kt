package com.example.week_3_assignment_cagrikirt.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_assignment_cagrikirt.R
import com.example.week_3_assignment_cagrikirt.models.adapters.DogAdapter
import com.example.week_3_assignment_cagrikirt.models.datamodels.DogModel
import com.example.week_3_assignment_cagrikirt.models.datamodels.MetaData


class RecyclerViewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dogList: List<DogModel> = MetaData().dogs
        println(dogList.first().name)
        val recyclerView = view.findViewById<RecyclerView>(R.id.dogs_list)

        //Unless below line is added android layour will skip this fragment
        val manager = LinearLayoutManager(this.context)

        recyclerView.layoutManager = manager
        recyclerView.adapter = DogAdapter(dogList) {

//bir problemden ötürü safeargs kullanamadım sorunumunuda çözemeyince bundle ile projeyi yapmaya karar verdim.
            val bundle = Bundle()
            bundle.putString("dogName", it.name)
            bundle.putString("personality", it.personality)

            findNavController().navigate(R.id.action_recyclerViewFragment_to_detailFragment, bundle)

        }
    }


}