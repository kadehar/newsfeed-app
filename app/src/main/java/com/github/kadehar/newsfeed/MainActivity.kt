package com.github.kadehar.newsfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.kadehar.newsfeed.databinding.ActivityMainBinding
import com.github.kadehar.newsfeed.features.news_screen.ui.NewsScreenFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainScreenNav.apply {
            setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.newsTab -> {
                        navigateTo(NewsScreenFragment())
                    }
                }
                true
            }
            selectedItemId = R.id.newsTab
        }
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}