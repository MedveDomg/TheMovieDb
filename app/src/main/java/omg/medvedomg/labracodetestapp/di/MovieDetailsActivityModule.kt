package omg.medvedomg.labracodetestapp.di

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import omg.medvedomg.labracodetestapp.mvp.presenter.ListOfMoviesPresenter
import omg.medvedomg.labracodetestapp.mvp.presenter.MovieDetailsPresenter
import omg.medvedomg.labracodetestapp.mvp.presenter.Presenter
import omg.medvedomg.labracodetestapp.mvp.view.ListOfMoviesView
import omg.medvedomg.labracodetestapp.mvp.view.MovieDetailsView
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.ui.activity.ListOfMoviesActivity
import omg.medvedomg.labracodetestapp.ui.activity.MovieDetailsActivity
import omg.medvedomg.labracodetestapp.ui.adapter.ListOfMoviesAdapter

/**
 * Created by medvedomg on 16.07.17.
 */
@Module
class MovieDetailsActivityModule {

    @Provides
    fun provideListOfMoviesView(view : MovieDetailsActivity) : MovieDetailsView {
        return view
    }

//    @PerActivity
    @Provides
    fun provideListOfMoviesPresenter(view: MovieDetailsView, api: Api) : Presenter {
        return MovieDetailsPresenter(view, api)
    }

}