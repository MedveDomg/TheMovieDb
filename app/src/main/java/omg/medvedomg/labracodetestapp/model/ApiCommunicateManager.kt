package omg.medvedomg.labracodetestapp.model

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import omg.medvedomg.labracodetestapp.model.data.ListOfPopularMoviesResponse
import omg.medvedomg.labracodetestapp.model.data.Movie
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.presenter.ListOfMoviesPresenter
import omg.medvedomg.labracodetestapp.presenter.MovieDetailsPresenter
import omg.medvedomg.labracodetestapp.presenter.Presenter

/**
 * Created by medvedomg on 04.07.17.
 */
class ApiCommunicateManager(val presenter: Presenter, val api: Api) {


    fun getListOfMoviesFromServer() {
        api.getPopularMoviesResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {

                    var movies = it.movies


                    //transform int id to string
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


                                movies.forEach {
                                    println("at the end: " + it.categories)
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

                    var movie = it

                    api.getCategoriesOfMoviesResponse()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(Consumer {
                                var categories = it.categories
                                    var fullCategory = ""
                                if (movie.genreIds != null) {
                                    for (index2 in 0..movie.genreIds.size - 1) {
                                        for (index3 in 0..categories.size - 1) {
                                            if (movie.genreIds.get(index2) == categories.get(index3).id) {
                                                fullCategory += categories.get(index3).name.plus(" ")
                                                movie.categories = fullCategory
                                            }
                                        }
                                    }
                                }

                            })

                    (presenter as MovieDetailsPresenter).setMovie(movie)
                })
    }

}