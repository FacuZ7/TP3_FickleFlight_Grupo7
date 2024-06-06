package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tp3_fickleflight_grupo7.MainActivity
import com.example.tp3_fickleflight_grupo7.R

class ExploreFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cambiar el estado de la toolbar
        (activity as? MainActivity)?.toolbarNoLogo(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Restaurar el estado de la toolbar cuando se destruye el fragmento
        (activity as? MainActivity)?.toolbarNoLogo(true)
    }


}