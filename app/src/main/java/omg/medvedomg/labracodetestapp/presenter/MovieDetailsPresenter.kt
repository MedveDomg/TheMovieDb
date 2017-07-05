package omg.medvedomg.labracodetestapp.presenter

import omg.medvedomg.labracodetestapp.model.ApiCommunicateManager
import omg.medvedomg.labracodetestapp.model.data.Movie
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.view.view.MovieDetailsView

/**
 * Created by medvedomg on 05.07.17.
 */
class MovieDetailsPresenter(var movieDetailsView: MovieDetailsView, private var api: Api) : Presenter{

    private val apiManager by lazy {   ApiCommunicateManager(this,api) }

    fun getMovieDetails(idMovie: String?) {
        //ask server to get some movies
        apiManager.getMovieDetails(idMovie)
    }

    fun setMovie(movie: Movie) {
        //send movie to activity
        movieDetailsView.setMovie(movie)
    }

}