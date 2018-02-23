package com.example.tictactoe.di;

import com.example.tictactoe.controller.GameStatusHandler;
import com.example.tictactoe.model.GameStatus;

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
