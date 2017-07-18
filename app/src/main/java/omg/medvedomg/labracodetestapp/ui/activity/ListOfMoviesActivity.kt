package omg.medvedomg.labracodetestapp.ui.activity

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_list_of_movies.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.mvp.model.Movie
import omg.medvedomg.labracodetestapp.di.NetworkModule
import omg.medvedomg.labracodetestapp.mvp.presenter.ListOfMoviesPresenter
import omg.medvedomg.labracodetestapp.mvp.presenter.Presenter
import omg.medvedomg.labracodetestapp.ui.adapter.ListOfMoviesAdapter
import omg.medvedomg.labracodetestapp.mvp.view.ListOfMoviesView
import omg.medvedomg.labracodetestapp.other.network.Api
import org.jetbrains.anko.toast
import javax.inject.Inject

class ListOfMoviesActivity : AppCompatActivity(), ListOfMoviesView {

    @Inject lateinit var linearLayoutManager: LinearLayoutManager
    @Inject lateinit var presenter: Presenter
    @Inject lateinit var adapterMovies: ListOfMoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_movies)

        //setup recyclerview
        rvListOfMovies.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            rvListOfMovies.adapter = adapterMovies
            println("applied all functions")
        }

        //ask present to get some movies
        if (NetworkModule.isNetworkConnected(this)) {
            println("NetworkModule.isNetworkConnected(this) = true")
            (presenter as ListOfMoviesPresenter).getListOfMovies()
        } else {
            toast(getString(R.string.check_your_internet_connection))
        }

    }

    override fun setMovies(movies: List<Movie>) {
        adapterMovies.loadMovies(movies)
    }
}
