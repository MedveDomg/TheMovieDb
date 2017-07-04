package omg.medvedomg.labracodetestapp.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_of_movies.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.model.ApiCommunicateManager
import omg.medvedomg.labracodetestapp.model.data.Movie
import omg.medvedomg.labracodetestapp.other.network.Api
import omg.medvedomg.labracodetestapp.other.network.NetworkUtil
import omg.medvedomg.labracodetestapp.presenter.ListOfMoviesPresenter
import omg.medvedomg.labracodetestapp.view.adapter.ListOfMoviesAdapter
import omg.medvedomg.labracodetestapp.view.viewInterface.ListOfMoviesView

class ListOfMoviesActivity : AppCompatActivity(), ListOfMoviesView {


    private val api = NetworkUtil.api

    private val presenter by lazy { ListOfMoviesPresenter(this, api)}
    private val adapterMovies by lazy { ListOfMoviesAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_movies)

        rvListOfMovies.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            rvListOfMovies.adapter = adapterMovies
        }

        presenter.getListOfMovies()
        
    }

    override fun startMovieDetailsActivity() {

    }

    override fun setMovies(movies: List<Movie>) {
        adapterMovies.loadMovies(movies)
    }
}
