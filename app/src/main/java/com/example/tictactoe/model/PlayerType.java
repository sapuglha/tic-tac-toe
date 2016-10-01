package com.example.tictactoe.model;

/**
 * Created by tiago on 2016-09-29.
 */
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