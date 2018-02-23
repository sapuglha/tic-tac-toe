package com.sapuglha.tictactoe.di

import com.sapuglha.tictactoe.ui.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity
}
