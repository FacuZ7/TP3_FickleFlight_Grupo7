package com.example.tp3_fickleflight_grupo7

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.tp3_fickleflight_grupo7.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar : Toolbar

    private lateinit var menuHamburguesa: ImageView
    private lateinit var logo: ImageView
    private lateinit var fotoPerfil: CardView
    private lateinit var menuTresPuntos: ImageView
    private lateinit var flechaAtras: ImageView

    private var isBackMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Inicialización de la Toolbar
        toolbar = findViewById(R.id.material_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //inicialización de variables de toolbar

        menuHamburguesa = findViewById(R.id.menu_hamburguesa)
        logo = findViewById(R.id.logo)
        fotoPerfil = findViewById(R.id.cardv_user_photo)
        menuTresPuntos = findViewById(R.id.menu_tres_puntos)
        flechaAtras = findViewById(R.id.flecha_atras)

        // Inicialización del DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)

        // Inicialización del NavigationView
        val navView: NavigationView = findViewById(R.id.drawer_navigation_view)

        // Inicialización del BottomNavigationView
        bottomNavView = findViewById(R.id.bottom_bar)


        // Inicialización del NavHostFragment
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        // Configuración del NavigationUI con el BottomNavigationView y el NavController
        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)

        // Configuración del NavigationUI con el NavigationView y el NavController
        NavigationUI.setupWithNavController(navView, navHostFragment.navController)


        menuHamburguesa.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        flechaAtras.setOnClickListener {
            onBackPressed()
        }
        isBackMode = savedInstanceState?.getBoolean("isBackMode") ?: false
        mostrarToolbarConAtras(isBackMode)
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

    fun mostrarToolbarConAtras(mostrar: Boolean) {
        isBackMode = mostrar
        if (mostrar) {
            menuHamburguesa.visibility = View.GONE
            logo.visibility = View.GONE
            fotoPerfil.visibility = View.GONE
            flechaAtras.visibility = View.VISIBLE
            menuTresPuntos.visibility = View.VISIBLE
        } else {
            menuHamburguesa.visibility = View.VISIBLE
            logo.visibility = View.VISIBLE
            fotoPerfil.visibility = View.VISIBLE
            flechaAtras.visibility = View.GONE
            menuTresPuntos.visibility = View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isBackMode", isBackMode)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}