package com.sapuglha.tictactoe.model

enum class PlayerType constructor(
        private val playerName: String
) {
    NONE("-"),
    X("X"),
    O("O");

    fun getName(): String {
        return playerName
    }
}