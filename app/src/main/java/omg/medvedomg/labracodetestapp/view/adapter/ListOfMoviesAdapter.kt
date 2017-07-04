package omg.medvedomg.labracodetestapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import omg.medvedomg.labracodetestapp.model.data.Movie
import omg.medvedomg.labracodetestapp.view.adapter.viewholder.MovieViewHolder

/**
 * Created by medvedomg on 04.07.17.
 */
class ListOfMoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies: ArrayList<Movie>

    init {
        movies = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        println("position: " + position)
        holder.bind(movies.get(position))
    }



    override fun getItemCount(): Int {
        return movies.size
    }

    fun loadMovies(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }
}