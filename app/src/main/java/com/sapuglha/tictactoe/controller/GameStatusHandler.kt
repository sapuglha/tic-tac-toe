package com.sapuglha.tictactoe.controller

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.sapuglha.tictactoe.BR
import com.sapuglha.tictactoe.R
import com.sapuglha.tictactoe.model.Board
import com.sapuglha.tictactoe.model.Board.Companion.MATRIX_SIZE
import com.sapuglha.tictactoe.model.PlayerType
import javax.inject.Inject

class GameStatusHandler @Inject constructor(
        private val game: Board
) : BaseObservable() {

    private var winner: PlayerType? = null
    private var currentPlayer: PlayerType = PlayerType.X

    fun play(x: Int, y: Int): Boolean {
        if (winner != null) return false

        val result = game.setPosition(x, y, currentPlayer) && checkForWinner(x, y, currentPlayer)
        setNextPlayer()
        if (result) {
            notifyPropertyChanged(com.sapuglha.tictactoe.BR.winner)
        }
        notifyPropertyChanged(BR._all)
        return result
    }

    fun reset() {
        game.reset()
        winner = null
        currentPlayer = PlayerType.X

        notifyPropertyChanged(com.sapuglha.tictactoe.BR.winner)
        notifyPropertyChanged(BR._all)
    }

    @Bindable
    fun getWinner(): String {
        return if (null != winner) winner!!.toString() else ""
    }

    fun getPlayerResource(x: Int, y: Int): Int {
        val position = game.getPosition(x, y) ?: return 0
        return when (position) {
            PlayerType.X -> R.drawable.player_x
            PlayerType.O -> R.drawable.player_o
        }
    }

    private fun setNextPlayer() {
        currentPlayer = if (currentPlayer === PlayerType.X) {
            PlayerType.O
        } else {
            PlayerType.X
        }
    }

    private fun checkForWinner(x: Int, y: Int, player: PlayerType): Boolean {
        var winnerCount = 0

        // Validate row, iterate columns:
        for (j in 0 until MATRIX_SIZE) {
            if (game.getPosition(x, j) === player) {
                winnerCount++
            } else {
                break
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            winner = player
            return true
        }

        // Validate column, iterate rows:
        winnerCount = 0
        for (i in 0 until MATRIX_SIZE) {
            if (game.getPosition(i, y) === player) {
                winnerCount++
            } else {
                break
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            winner = player
            return true
        }

        // Validate one diagonal, but only if the played position has the same X and Y
        winnerCount = 0
        if (x == y) {
            for (i in 0 until MATRIX_SIZE) {
                if (game.getPosition(i, i) === player) {
                    winnerCount++
                } else {
                    break
                }
            }
        }

        if (winnerCount == MATRIX_SIZE) {
            winner = player
            return true
        }

        // Finally, check the other diagonal
        winnerCount = 0
        var j = 0
        for (i in MATRIX_SIZE - 1 downTo 0) {
            if (game.getPosition(i, j) === player) {
                winnerCount++
                j++
            } else {
                break
            }
        }

        return if (winnerCount == MATRIX_SIZE) {
            winner = player
            true
        } else {
            false
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("image")
        fun imageBinding(imageView: ImageView, resource: Int) {
            imageView.setImageResource(resource)
        }
    }
}