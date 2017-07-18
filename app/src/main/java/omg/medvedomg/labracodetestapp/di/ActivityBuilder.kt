package omg.medvedomg.labracodetestapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import omg.medvedomg.labracodetestapp.ui.activity.ListOfMoviesActivity
import omg.medvedomg.labracodetestapp.ui.activity.MovieDetailsActivity
import javax.inject.Singleton

/**
 * Created by medvedomg on 16.07.17.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(ListOfMoviesActivityModule::class))
    abstract fun bindListOfMoviesActivity() : ListOfMoviesActivity

    @ContributesAndroidInjector(modules = arrayOf(MovieDetailsActivityModule::class))
    abstract fun bindMovieDetailsActivity() : MovieDetailsActivity

}