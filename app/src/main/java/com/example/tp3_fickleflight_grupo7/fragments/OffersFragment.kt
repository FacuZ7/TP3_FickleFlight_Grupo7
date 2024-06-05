package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.adapter.OfferAdapter
import com.example.tp3_fickleflight_grupo7.entities.Offer

class OffersFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var offerAdapter: OfferAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_offers)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val offers = mutableListOf<Offer>().apply {
            add(Offer(getString(R.string.visa_discount), getString(R.string.visa_discount_text), R.drawable.visa_card, R.drawable.vector_1))
            add(Offer(getString(R.string.mastercard_title), getString(R.string.mastercard_text), R.drawable.mastercard_card, R.drawable.vector_1))


        }
        offerAdapter = OfferAdapter(offers)

        recyclerView.adapter = offerAdapter
    }
}