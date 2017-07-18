package omg.medvedomg.labracodetestapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_movie_details.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.mvp.model.Movie
import omg.medvedomg.labracodetestapp.other.DateParserUtil
import omg.medvedomg.labracodetestapp.other.loadImg
import omg.medvedomg.labracodetestapp.di.NetworkModule
import omg.medvedomg.labracodetestapp.mvp.presenter.MovieDetailsPresenter
import omg.medvedomg.labracodetestapp.mvp.presenter.Presenter
import omg.medvedomg.labracodetestapp.mvp.view.MovieDetailsView
import org.jetbrains.anko.toast
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity(), MovieDetailsView {

    val KEY_MOVIE_ID: String = "947"

    @Inject lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        /*
        receive id of movie from movie list
        and ask presenter to load info from server
        about this movie
         */
        if (NetworkModule.isNetworkConnected(this)) {
            (presenter as MovieDetailsPresenter).getMovieDetails(intent.getStringExtra(KEY_MOVIE_ID))
        } else {
            toast(getString(R.string.check_your_internet_connection))
        }

    }

    //set movie values
    override fun setMovie(movie: Movie) {
        tvTitle.text = movie.title
        ivPoster.loadImg(movie.posterPath.toString())
        tvYear.text = String.format(resources.getString(R.string.year),DateParserUtil.parseDate(movie.release_date))
        tvBudget.text = String.format(resources.getString(R.string.budget),movie.budget)
        tvLink.text = movie.link
        tvOverview.text = movie.overview
    }


}
