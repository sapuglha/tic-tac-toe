package com.sapuglha.tictactoe.model

import android.support.annotation.VisibleForTesting

class Board {
    private lateinit var board: Array<Array<PlayerType?>>

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val matrix: Array<Array<PlayerType?>>
        get() {
            return board
        }

    init {
        reset()
    }

    fun getPosition(x: Int, y: Int): PlayerType? {
        return board[x][y]
    }

    fun setPosition(x: Int, y: Int, currentPlayer: PlayerType): Boolean {
        // Check that the given location is not already played, or played by the same user
        if (board[x][y] != null || board[x][y] === currentPlayer) {
            return false
        }

        // assign the player to that position
        board[x][y] = currentPlayer

        return true
    }

    fun reset() {
        board = Array(MATRIX_SIZE) { Array<PlayerType?>(MATRIX_SIZE) { null } }
    }

    companion object {
        const val MATRIX_SIZE: Int = 3
    }
}
