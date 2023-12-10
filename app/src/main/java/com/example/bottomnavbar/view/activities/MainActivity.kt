package com.example.bottomnavbar.view.activities;
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView  // Ajoutez cette ligne
import com.example.bottomnavbar.R
import com.example.bottomnavbar.view.fragment.ForumFragment

// MainActivity.kt
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ne remplacez pas manuellement le fragment ici
        // Supprimez cette partie :
        // val forumFragment = ForumFragment()
        // supportFragmentManager.beginTransaction()
        //     .replace(R.id.nav_fragment, forumFragment)
        //     .commit()

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        val navHost = findNavController(R.id.nav_fragment)

        bottomNavView.setupWithNavController(navHost)
    }
}
