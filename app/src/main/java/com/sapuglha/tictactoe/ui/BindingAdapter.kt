package com.sapuglha.tictactoe.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sapuglha.tictactoe.R
import com.sapuglha.tictactoe.model.PlayerType

@BindingAdapter("android:src")
fun imageBinding(imageView: ImageView, player: PlayerType?) {
    when (player) {
        PlayerType.X -> imageView.setImageResource(R.drawable.player_x)
        PlayerType.O -> imageView.setImageResource(R.drawable.player_o)
    }
}