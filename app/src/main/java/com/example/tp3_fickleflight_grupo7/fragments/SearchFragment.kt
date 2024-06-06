package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.adapter.OfferAdapter
import com.example.tp3_fickleflight_grupo7.entities.Offer
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class SearchFragment : Fragment() {

    lateinit var fragment : View
    lateinit var btnSearch: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragment = inflater.inflate(R.layout.fragment_search, container, false)
        btnSearch = fragment.findViewById(R.id.search_button)
        val datePickerButton = fragment.findViewById<TextInputEditText>(R.id.date_picker_button)
        btnSearch.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchToSearchResultFragment()
            fragment.findNavController().navigate(action)
        }
        datePickerButton.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Selecciona una fecha")
                    .setTheme(R.style.CalendarTheme)
                    .build()

            datePicker.addOnPositiveButtonClickListener { selection ->
                val selectedDate =
                    Instant.ofEpochMilli(selection).atZone(ZoneId.systemDefault()).toLocalDate()
                val formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(selectedDate)
                datePickerButton.setText(formattedDate)
            }

            datePicker.show(childFragmentManager, "MATERIAL_DATE_PICKER")
        }

        val recyclerView = fragment.findViewById<RecyclerView>(R.id.offers_horizontal_search)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val offers = mutableListOf<Offer>().apply {
            add(
                Offer(
                    "20% discount for mastercard users",
                    "Limited time offer!",
                    R.drawable.mastercard_card,
                    null,
                    false
                )
            )
            add(
                Offer(
                    "25% discount with your Visa credit cards",
                    "Limited time offer!",
                    R.drawable.visa_card,
                    null,
                    false
                )
            )


        }
        val offerAdapter = OfferAdapter(offers, true)
        recyclerView.adapter = offerAdapter

        return fragment
    }

    override fun onStart() {
        super.onStart()

        btnSearch.setOnClickListener{

            val action = SearchFragmentDirections.actionSearchToSearchResultFragment()
            fragment.findNavController().navigate(action)
        }

    }

}