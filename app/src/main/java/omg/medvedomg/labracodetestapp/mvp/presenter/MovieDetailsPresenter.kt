package omg.medvedomg.labracodetestapp.mvp.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import omg.medvedomg.labracodetestapp.other.ApiCommunicateManager
import omg.medvedomg.labracodetestapp.mvp.model.Movie
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.mvp.view.MovieDetailsView

/**
 * Created by medvedomg on 05.07.17.
 */
class MovieDetailsPresenter(var movieDetailsView: MovieDetailsView, private var api: Api) : Presenter{

    fun getMovieDetails(idMovie: String?) {
        //ask server to get some movies
        api.getMovieDetailsResponse(idEvent = idMovie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    setMovie(it)
                })
    }

    fun setMovie(movie: Movie) {
        //send movie to activity
        movieDetailsView.setMovie(movie)
    }

}