package com.sapuglha.tictactoe.di

import com.sapuglha.tictactoe.controller.GameStatusHandler
import com.sapuglha.tictactoe.model.GameStatus

import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    internal fun provideGameStatus(): GameStatus {
        return GameStatus()
    }

    @Provides
    internal fun provideGameStatusHandler(gameStatus: GameStatus): GameStatusHandler {
        return GameStatusHandler(gameStatus)
    }
}