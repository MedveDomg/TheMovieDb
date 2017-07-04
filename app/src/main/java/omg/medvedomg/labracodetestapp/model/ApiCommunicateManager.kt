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

/**
 * Created by medvedomg on 04.07.17.
 */
class ApiCommunicateManager(val presenter: ListOfMoviesPresenter, val api: Api) {




    fun getListOfMoviesFromServer() {
        api.getPopularMoviesResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {

                    var movies = it.movies


                    api.getCategoriesOfMoviesResponse()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
//                            .doOnComplete(Action { presenter.setListOfMovies(it.movies) })
                            .subscribe(Consumer {
                                var categories = it.categories
                                for (index in 0..movies.size - 1) {
//                                    movies.get(index).categories = "peremoga"
                                    var fullCategory = ""
                                    for (index2 in 0..movies.get(index).genreIds.size - 1) {
                                        for (index3 in 0..categories.size - 1) {
                                            if (movies.get(index).genreIds.get(index2) == categories.get(index3).id) {
                                                println("true")
                                                println("categories.get(index3).name:" + categories.get(index3).name)
//                                                if (index3 == (categories.size - 1)) {
//                                                    fullCategory += categories.get(index3).name
//                                                } else {
                                                    fullCategory += categories.get(index3).name.plus(" ")
//                                                }
                                                movies.get(index).categories = fullCategory
                                            }
                                        }
                                    }
                                }


                                movies.forEach {
                                    println("at the end: " + it.categories)
                                }

                                presenter.setListOfMovies(movies)
                            })
                })

    }

}