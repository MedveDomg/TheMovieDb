package omg.medvedomg.labracodetestapp.mvp.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import omg.medvedomg.labracodetestapp.other.ApiCommunicateManager
import omg.medvedomg.labracodetestapp.mvp.model.Movie
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.mvp.view.ListOfMoviesView
import omg.medvedomg.labracodetestapp.ui.activity.ListOfMoviesActivity
import javax.inject.Inject

/**
 * Created by medvedomg on 04.07.17.
 */
class ListOfMoviesPresenter(var listOfMoviesView: ListOfMoviesView, var api: Api) : Presenter {

    fun getListOfMovies() {
        //ask server to get some movies


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

                                setListOfMovies(movies)
                            })
                })
    }

    fun setListOfMovies(movies: List<Movie>) {
        //send movies to activity
        listOfMoviesView.setMovies(movies)
    }
}