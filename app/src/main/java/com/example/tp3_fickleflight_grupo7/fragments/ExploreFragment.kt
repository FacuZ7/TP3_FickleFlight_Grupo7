package com.example.tp3_fickleflight_grupo7.fragments

import SharedPreferencesModule
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.MainActivity
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.adapter.DestinationAdapter
import com.example.tp3_fickleflight_grupo7.adapter.OfferAdapter
import com.example.tp3_fickleflight_grupo7.entities.Destination
import com.example.tp3_fickleflight_grupo7.entities.Offer
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class ExploreFragment : Fragment() {
    @Inject
    lateinit var sharedPreferencesModule: SharedPreferencesModule


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
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_offers_horizontal)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val offers= mutableListOf<Offer>().apply {
            add(Offer("20% discount for mastercard users", "Limited time offer!", R.drawable.mastercard_card, null)  )
            add(Offer("25% discount with your Visa credit cards", "Limited time offer!", R.drawable.visa_card, null))



        }
        val destination1 = Destination(R.drawable.boracay_philippines, "Baracay", "Philippines", "5D4N")
        val destination2 = Destination(R.drawable.baros, "Baros", "Maldives", "7D6N")
        val destination3 = Destination(R.drawable.bali, "Bali", "Indonesia", "3D2N")
        val destination4 = Destination(R.drawable.palawan, "Palawan", "Philippines", "3D2N")
        val destinations = mutableListOf(destination1, destination2, destination3, destination4)


        val recyclerViewDestinations = view.findViewById<RecyclerView>(R.id.recycler_view_destinations)
        recyclerViewDestinations.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val destinationAdapter = DestinationAdapter(destinations, sharedPreferencesModule)
        recyclerViewDestinations.adapter = destinationAdapter

        val offerAdapter = OfferAdapter(offers, true)
        recyclerView.adapter = offerAdapter
        (activity as? MainActivity)?.toolbarNoLogo(false)
    }


    override fun onDestroyView() {
        super.onDestroyView()

        (activity as? MainActivity)?.toolbarNoLogo(true)
    }


}