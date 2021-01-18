package com.nextwo.hiltapp.presentation.di

import androidx.fragment.app.Fragment
import com.nextwo.hiltapp.data.repo.DishesRepoImpl
import com.nextwo.hiltapp.data.source.DataSource
import com.nextwo.hiltapp.domain.repo.IDishesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class DishesModule {

    //Order of dependencies is important

    //@Singleton
    //@ActivityScoped
    //@FragmentScoped
    @Provides
    fun provideDataSource(): DataSource{
        return DataSource("Local")
    }

    //@Singleton
    //@ActivityScoped //To use same instance in all sub components like fragments
    //@FragmentScoped
    @Provides
    fun provideDishesRepository(dataSource: DataSource): IDishesRepo{
        return DishesRepoImpl(dataSource)
    }
}