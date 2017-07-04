package omg.medvedomg.labracodetestapp.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import omg.medvedomg.labracodetestapp.model.ApiCommunicateManager
import omg.medvedomg.labracodetestapp.model.data.Movie
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.view.viewInterface.ListOfMoviesView

/**
 * Created by medvedomg on 04.07.17.
 */
class ListOfMoviesPresenter(var listOfMoviesView: ListOfMoviesView, private var api: Api) {

    private val apiManager by lazy {   ApiCommunicateManager(this,api)}

    fun getListOfMovies() {


        //ask server to get some movies
//        api.getPopularMoviesResponse("73ca768a64e4fb7f37e044d22a437a93","1")
//                .subscribeOn(Schedulers.io())
//                .map { t ->
//                    t.movies
//                }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(Consumer {
//                    //send list of movies to activity
//                    listOfMoviesView.setMovies(it)
//                })
        apiManager.getListOfMoviesFromServer()
    }

    fun setListOfMovies(movies: List<Movie>) {
        listOfMoviesView.setMovies(movies)
    }
}