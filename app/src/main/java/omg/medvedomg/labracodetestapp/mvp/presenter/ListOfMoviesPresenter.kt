package omg.medvedomg.labracodetestapp.mvp.presenter

import omg.medvedomg.labracodetestapp.other.ApiCommunicateManager
import omg.medvedomg.labracodetestapp.mvp.model.Movie
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.mvp.view.ListOfMoviesView

/**
 * Created by medvedomg on 04.07.17.
 */
class ListOfMoviesPresenter(var listOfMoviesView: ListOfMoviesView, private var api: Api) : Presenter{

    private val apiManager by lazy { ApiCommunicateManager(this, api) }

    fun getListOfMovies() {
        //ask server to get some movies
        apiManager.getListOfMoviesFromServer()
    }

    fun setListOfMovies(movies: List<Movie>) {
        //send movies to activity
        listOfMoviesView.setMovies(movies)
    }
}