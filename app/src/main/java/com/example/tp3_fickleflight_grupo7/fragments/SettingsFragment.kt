package com.example.tp3_fickleflight_grupo7.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.tp3_fickleflight_grupo7.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_preference, rootKey)

    }

}