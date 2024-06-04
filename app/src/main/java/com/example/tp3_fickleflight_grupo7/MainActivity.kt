package com.example.tp3_fickleflight_grupo7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
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
    private lateinit var navigationView: NavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var toolbar : Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Inicialización de la Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Inicialización del DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)

        // Inicialización del NavigationView
        val navView: NavigationView = findViewById(R.id.drawer_navigation_view)

        // Inicialización del BottomNavigationView
        bottomNavView = findViewById(R.id.bottom_bar)

        // Inicialización del NavHostFragment
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        // Configuración del AppBarConfiguration
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.user_profile),
            drawerLayout
        )
        // Configuración del NavigationUI con el BottomNavigationView y el NavController
        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)

        // Configuración del NavigationUI con el NavigationView y el NavController
        NavigationUI.setupWithNavController(navView, navHostFragment.navController)

        // Configuración del NavigationUI con la Toolbar y el NavController
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController, appBarConfiguration)

        // Configuración del ícono del menú hamburguesa
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    /*
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.drawer_navigation_view)

        //setupDrawerLayout()
        bottomNavView = findViewById(R.id.bottom_bar)
        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)


        toolbar= findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    */

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = navHostFragment.navController
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}