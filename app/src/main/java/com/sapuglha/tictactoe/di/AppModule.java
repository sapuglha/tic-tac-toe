package com.sapuglha.tictactoe.di;

import com.sapuglha.tictactoe.controller.GameStatusHandler;
import com.sapuglha.tictactoe.model.GameStatus;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    GameStatus provideGameStatus() {
        return new GameStatus();
    }

    @Provides
    GameStatusHandler provideGameStatusHandler() {
        return new GameStatusHandler(new GameStatus());
    }
}
