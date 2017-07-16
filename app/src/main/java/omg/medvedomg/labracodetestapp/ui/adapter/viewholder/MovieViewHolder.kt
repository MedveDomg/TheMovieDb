package omg.medvedomg.labracodetestapp.ui.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_item.view.*
import omg.medvedomg.labracodetestapp.R
import omg.medvedomg.labracodetestapp.mvp.model.Movie
import omg.medvedomg.labracodetestapp.other.DateParserUtil
import omg.medvedomg.labracodetestapp.other.inflate
import omg.medvedomg.labracodetestapp.other.loadImg

/**
 * Created by medvedomg on 04.07.17.
 */
class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.movie_item)) {

    //bind all values to views
    fun bind(item: Movie) = with(itemView) {
        tvTitle.text = item.title
        tvScore.text = item.voteAverage.toString()
        ivPoster.loadImg(item.posterPath.toString())
        tvYear.text = DateParserUtil.parseDate(item.release_date)
        tvCategories.text = item.categories
        tvDescription.text = item.overview
    }
}