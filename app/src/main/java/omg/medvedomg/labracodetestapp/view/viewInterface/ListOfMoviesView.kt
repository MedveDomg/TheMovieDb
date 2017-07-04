package omg.medvedomg.labracodetestapp.view.viewInterface

import omg.medvedomg.labracodetestapp.model.data.Movie

/**
 * Created by medvedomg on 04.07.17.
 */
interface ListOfMoviesView {

    fun setMovies(movies: List<Movie>)

    fun startMovieDetailsActivity()

}