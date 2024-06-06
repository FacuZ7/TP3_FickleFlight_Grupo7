package com.example.tp3_fickleflight_grupo7.ui

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.example.tp3_fickleflight_grupo7.R
import com.example.tp3_fickleflight_grupo7.dao.FavCardDao
import com.example.tp3_fickleflight_grupo7.models.FavCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavCardFragment : Fragment(R.layout.paris_card) {

    @Inject
    lateinit var favCardDao: FavCardDao

    private lateinit var favoriteButton: CheckBox

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteButton = view.findViewById(R.id.favorite_button)
        setupFavoriteButton()
    }

    private fun setupFavoriteButton() {
        CoroutineScope(Dispatchers.IO).launch {
            val favCardId = R.layout.paris_card // Reemplaza esto con el id de tu tarjeta favorita
            val favCard = favCardDao.getFavCard(favCardId)
            favoriteButton.isChecked = favCard?.isFavorite ?: false

            favoriteButton.setOnCheckedChangeListener { _, isChecked ->
                val updatedFavCard = favCard?.copy(isFavorite = isChecked) ?: FavCard(favCardId, isChecked)
                launch { favCardDao.insertOrUpdate(updatedFavCard) }
            }
        }
    }
}