package omg.medvedomg.labracodetestapp.di

import android.app.Application
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import omg.medvedomg.labracodetestapp.mvp.presenter.ListOfMoviesPresenter
import omg.medvedomg.labracodetestapp.mvp.presenter.Presenter
import omg.medvedomg.labracodetestapp.mvp.view.ListOfMoviesView
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.ui.activity.ListOfMoviesActivity
import omg.medvedomg.labracodetestapp.ui.adapter.ListOfMoviesAdapter
import javax.inject.Singleton

/**
 * Created by medvedomg on 16.07.17.
 */
@Module
class ListOfMoviesActivityModule {

    @Provides
    fun provideListOfMoviesView(view :ListOfMoviesActivity) : ListOfMoviesView {
        return view
    }

//    @PerActivity
    @Provides
    fun provideLinearLayoutManager(application : Context) : LinearLayoutManager {
        return LinearLayoutManager(application)
    }
//
//    @PerActivity
    @Provides
    fun provideListOfMoviesAdapter(view :ListOfMoviesView, context: Context) : ListOfMoviesAdapter {
        return ListOfMoviesAdapter(view, context)
    }
//
//    @PerActivity
    @Provides
    fun provideListOfMoviesPresenter(view: ListOfMoviesView, api: Api) : Presenter {
        return ListOfMoviesPresenter(view, api)
    }
}