package omg.medvedomg.labracodetestapp.mvp.presenter

import omg.medvedomg.labracodetestapp.other.ApiCommunicateManager
import omg.medvedomg.labracodetestapp.mvp.model.Movie
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.mvp.view.MovieDetailsView

/**
 * Created by medvedomg on 05.07.17.
 */
class MovieDetailsPresenter(var movieDetailsView: MovieDetailsView, private var api: Api) : Presenter{

    private val apiManager by lazy { ApiCommunicateManager(this, api) }

    fun getMovieDetails(idMovie: String?) {
        //ask server to get some movies
        apiManager.getMovieDetails(idMovie)
    }

    fun setMovie(movie: Movie) {
        //send movie to activity
        movieDetailsView.setMovie(movie)
    }

}