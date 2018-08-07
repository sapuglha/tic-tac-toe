package com.sapuglha.tictactoe.ui

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.sapuglha.tictactoe.R
import com.sapuglha.tictactoe.model.PlayerType

@BindingAdapter("android:src")
fun imageBinding(imageView: ImageView, player: PlayerType?) {
    when (player) {
        PlayerType.X -> imageView.setImageResource(R.drawable.player_x)
        PlayerType.O -> imageView.setImageResource(R.drawable.player_o)
    }
}