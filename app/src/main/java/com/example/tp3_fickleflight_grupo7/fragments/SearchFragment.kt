package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.tp3_fickleflight_grupo7.R


class SearchFragment : Fragment() {

    lateinit var fragment : View
    lateinit var btnSearch: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragment = inflater.inflate(R.layout.fragment_search, container, false)
        btnSearch = fragment.findViewById(R.id.srch_btn_search)

        return fragment
    }

    override fun onStart() {
        super.onStart()

        btnSearch.setOnClickListener{
            val action = SearchFragmentDirections.actionSearchFragmentToSearchResultFragment()

            fragment.findNavController().navigate(action)
        }

    }


}