package omg.medvedomg.labracodetestapp.other

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.mvp.presenter.ListOfMoviesPresenter
import omg.medvedomg.labracodetestapp.mvp.presenter.MovieDetailsPresenter
import omg.medvedomg.labracodetestapp.mvp.presenter.Presenter

/**
 * Created by medvedomg on 04.07.17.
 */

//manager for loading data from server
class ApiCommunicateManager(val presenter: Presenter, val api: Api) {


    fun getListOfMoviesFromServer() {

         api.getPopularMoviesResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {

                    var movies = it.movies


                    //transform int id of category to string and set it to movie
                    api.getCategoriesOfMoviesResponse()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(Consumer {
                                var categories = it.categories
                                for (index in 0..movies.size - 1) {
                                    var fullCategory = ""
                                    for (index2 in 0..movies.get(index).genreIds.size - 1) {
                                        for (index3 in 0..categories.size - 1) {
                                            if (movies.get(index).genreIds.get(index2) == categories.get(index3).id) {
                                                    fullCategory += categories.get(index3).name.plus(" ")
                                                movies.get(index).categories = fullCategory
                                            }
                                        }
                                    }
                                }

                                (presenter as ListOfMoviesPresenter).setListOfMovies(movies)
                            })
                })

    }

    fun getMovieDetails(id: String?) {
        api.getMovieDetailsResponse(idEvent = id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    (presenter as MovieDetailsPresenter).setMovie(it)
                })
    }

}