package com.sapuglha.tictactoe.model

enum class PlayerType constructor(private val stringValue: String) {
    NONE("-"),
    X("X"),
    O("O");

    override fun toString(): String {
        return stringValue
    }
}