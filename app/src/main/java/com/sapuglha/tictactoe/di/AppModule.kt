package com.sapuglha.tictactoe.di

import com.sapuglha.tictactoe.controller.GameStatusHandler
import com.sapuglha.tictactoe.model.Board

import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    internal fun provideGameStatus(): Board {
        return Board()
    }

    @Provides
    internal fun provideGameStatusHandler(gameStatus: Board): GameStatusHandler {
        return GameStatusHandler(gameStatus)
    }
}