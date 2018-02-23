package com.example.tictactoe.model;

public enum PlayerType {
    NONE("-"),
    X("X"),
    O("O");

    private final String stringValue;

    PlayerType(String toString) {
        stringValue = toString;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}