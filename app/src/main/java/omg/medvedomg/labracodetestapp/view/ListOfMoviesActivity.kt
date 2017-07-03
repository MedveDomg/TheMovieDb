package omg.medvedomg.labracodetestapp.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_of_movies.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.presenter.ListOfMoviesPresenter
import omg.medvedomg.labracodetestapp.view.adapter.ListOfMoviesAdapter
import omg.medvedomg.labracodetestapp.view.viewInterface.ListOfMoviesView

class ListOfMoviesActivity : AppCompatActivity(), ListOfMoviesView {

    private val presenter by lazy { ListOfMoviesPresenter(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_movies)

        rvListOfMovies.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            rvListOfMovies.adapter = ListOfMoviesAdapter()
        }


    }

    override fun setMovies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startMovieDetailsActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
