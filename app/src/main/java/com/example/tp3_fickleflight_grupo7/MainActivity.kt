package com.example.tp3_fickleflight_grupo7

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navigationView : NavigationView
    private lateinit var navHostFragment : NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar : Toolbar

    private var isBackMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolbar()
        setNavigations()
        setNavigationsSetup()
    }

    private fun setToolbar(){
        toolbar = findViewById(R.id.material_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setNavigations(){
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.drawer_navigation_view)
        bottomNavView = findViewById(R.id.bottom_bar)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
    }

    private fun setNavigationsSetup(){
        val navController = navHostFragment.navController
        navigationView.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        NavigationUI.setupWithNavController(bottomNavView, navController)
    }

    fun applyTheme() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val darkMode = sharedPreferences.getBoolean("night_mode", false)
        if (darkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    fun toolbarNoLogo(mostrar: Boolean) {
        var logo: ImageView = findViewById(R.id.logo)
        var fotoPerfil: CardView = findViewById(R.id.cardv_user_photo)
        var menuTresPuntos: ImageView = findViewById(R.id.menu_tres_puntos)

        if (mostrar) {
            logo.visibility = View.GONE
            fotoPerfil.visibility = View.GONE
            menuTresPuntos.visibility = View.VISIBLE
        } else {
            logo.visibility = View.VISIBLE
            fotoPerfil.visibility = View.VISIBLE
            menuTresPuntos.visibility = View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isBackMode", isBackMode)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navHostFragment.navController,drawerLayout)
    }
}