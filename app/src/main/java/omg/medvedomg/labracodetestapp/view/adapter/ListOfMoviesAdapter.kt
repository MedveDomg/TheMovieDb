package omg.medvedomg.labracodetestapp.view.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_item.view.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.model.data.Movie
import omg.medvedomg.labracodetestapp.other.network.NetworkUtil
import omg.medvedomg.labracodetestapp.view.activity.ListOfMoviesActivity
import omg.medvedomg.labracodetestapp.view.activity.MovieDetailsActivity
import omg.medvedomg.labracodetestapp.view.adapter.viewholder.MovieViewHolder
import org.jetbrains.anko.toast

/**
 * Created by medvedomg on 04.07.17.
 */
class ListOfMoviesAdapter(val activity: ListOfMoviesActivity) : RecyclerView.Adapter<MovieViewHolder>() {

    val KEY_MOVIE_ID: String = "947"

    private var movies: ArrayList<Movie>

    init {
        movies = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies.get(position))

            holder.itemView.tvMoreInfo.setOnClickListener(View.OnClickListener {
                if (NetworkUtil.isNetworkConnected(activity)) {
                val intent = Intent(activity, MovieDetailsActivity::class.java)
                intent.putExtra(KEY_MOVIE_ID,movies.get(position).id.toString())
                activity.startActivity(intent)
                } else {
                    activity.toast(activity.getString(R.string.check_your_internet_connection))
                }
            })



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