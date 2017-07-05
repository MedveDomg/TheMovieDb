package omg.medvedomg.labracodetestapp.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_details.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.other.DateParserUtil
import omg.medvedomg.labracodetestapp.other.loadImg
import omg.medvedomg.labracodetestapp.other.network.NetworkUtil
import omg.medvedomg.labracodetestapp.presenter.MovieDetailsPresenter
import omg.medvedomg.labracodetestapp.view.view.MovieDetailsView
import org.jetbrains.anko.toast

class MovieDetailsActivity : AppCompatActivity(), MovieDetailsView {

    val KEY_MOVIE_ID: String = "947"

    private val api = NetworkUtil.api
    private val presenter by lazy { MovieDetailsPresenter(this, api) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        /*
        receive id of movie from movie list
        and ask presenter to load info from server
        about this movie
         */
        if (NetworkUtil.isNetworkConnected(this)) {
            presenter.getMovieDetails(intent.getStringExtra(KEY_MOVIE_ID))
        } else {
            toast(getString(R.string.check_your_internet_connection))
        }

    }

    //set movie values
    override fun setMovie(movie: omg.medvedomg.labracodetestapp.model.data.Movie) {
        tvTitle.text = movie.title
        ivPoster.loadImg(movie.posterPath.toString())
        tvYear.text = String.format(resources.getString(R.string.year),DateParserUtil.parseDate(movie.release_date))
        tvBudget.text = String.format(resources.getString(R.string.budget),movie.budget)
        tvLink.text = movie.link
        tvOverview.text = movie.overview
    }


}
