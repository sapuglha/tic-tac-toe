package com.sapuglha.tictactoe.ui

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.sapuglha.tictactoe.R
import com.sapuglha.tictactoe.controller.GameStatusHandler
import com.sapuglha.tictactoe.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var handler: GameStatusHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.gameHandler = handler
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_game -> {
                handler.reset()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
