package omg.medvedomg.labracodetestapp.mvp.view

import android.support.v7.app.AppCompatActivity
import omg.medvedomg.labracodetestapp.mvp.model.Movie

/**
 * Created by medvedomg on 04.07.17.
 */
interface ListOfMoviesView {

    fun setMovies(movies: List<Movie>)

}