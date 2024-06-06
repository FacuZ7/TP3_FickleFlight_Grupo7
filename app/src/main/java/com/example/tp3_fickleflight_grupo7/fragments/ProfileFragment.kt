package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tp3_fickleflight_grupo7.R
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tp3_fickleflight_grupo7.MainActivity


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Ocultar la Toolbar
        (activity as? MainActivity)?.supportActionBar?.hide()

        val backButton = view.findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        // Cargar imagen circular con Glide
        val profileImage = view.findViewById<ImageView>(R.id.profileImage)
        Glide.with(this)
            .load(R.drawable.profile_pic_macy_johnson)
            .apply(RequestOptions.circleCropTransform())
            .into(profileImage)



        val settingsButton = view.findViewById<TextView>(R.id.profile_settings_button)
        settingsButton.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_settings)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Mostrar la Toolbar
        (activity as? MainActivity)?.supportActionBar?.show()
    }
}