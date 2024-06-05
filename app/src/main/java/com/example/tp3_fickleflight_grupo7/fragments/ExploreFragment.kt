package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.MainActivity
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.adapter.OfferAdapter
import com.example.tp3_fickleflight_grupo7.entities.Offer

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
        (activity as? MainActivity)?.mostrarToolbarConAtras(false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_offers_horizontal)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val offers= mutableListOf<Offer>().apply {
            add(Offer("20% discount for mastercard users", "Limited time offer!", R.drawable.mastercard_card, null)  )
             add(Offer("25% discount with your Visa credit cards", "Limited time offer!", R.drawable.visa_card, null))



    }

        val offerAdapter = OfferAdapter(offers, true)
        recyclerView.adapter = offerAdapter



    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Restaurar el estado de la toolbar cuando se destruye el fragmento
        (activity as? MainActivity)?.mostrarToolbarConAtras(true)
    }


}