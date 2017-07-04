package omg.medvedomg.labracodetestapp.view.adapter.viewholder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.movie_item.view.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.model.data.Movie
import omg.medvedomg.labracodetestapp.other.DateParserUtil
import omg.medvedomg.labracodetestapp.other.inflate
import omg.medvedomg.labracodetestapp.other.loadImg
import omg.medvedomg.labracodetestapp.view.activity.MovieDetailsActivity

/**
 * Created by medvedomg on 04.07.17.
 */
class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.movie_item)) {


    fun bind(item: Movie) = with(itemView) {
        tvTitle.text = item.title
        tvScore.text = item.voteAverage.toString()
        ivPoster.loadImg(item.posterPath.toString())
        tvYear.text = DateParserUtil.parseDate(item.release_date)
        tvCategories.text = item.categories
        tvDescription.text = item.overview
    }
}