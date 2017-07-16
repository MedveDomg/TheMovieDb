package omg.medvedomg.labracodetestapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_of_movies.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.mvp.model.Movie
import omg.medvedomg.labracodetestapp.other.network.NetworkUtil
import omg.medvedomg.labracodetestapp.mvp.presenter.ListOfMoviesPresenter
import omg.medvedomg.labracodetestapp.ui.adapter.ListOfMoviesAdapter
import omg.medvedomg.labracodetestapp.mvp.view.ListOfMoviesView
import org.jetbrains.anko.toast

class ListOfMoviesActivity : AppCompatActivity(), ListOfMoviesView {


    private val api = NetworkUtil.api

    private val presenter by lazy { ListOfMoviesPresenter(this, api)}
    private val adapterMovies by lazy { ListOfMoviesAdapter(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_movies)

        //setup recyclerview
        rvListOfMovies.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            rvListOfMovies.adapter = adapterMovies
        }

        //ask present to get some movies
        if (NetworkUtil.isNetworkConnected(this)) {
            presenter.getListOfMovies()
        } else {
            toast(getString(R.string.check_your_internet_connection))
        }

    }


    override fun setMovies(movies: List<Movie>) {
        adapterMovies.loadMovies(movies)
    }
}
