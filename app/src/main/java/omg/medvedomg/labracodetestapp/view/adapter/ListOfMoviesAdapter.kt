package omg.medvedomg.labracodetestapp.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import omg.medvedomg.labracodetestapp.view.adapter.viewholder.MovieViewHolder

/**
 * Created by medvedomg on 04.07.17.
 */
class ListOfMoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(p0: MovieViewHolder?, p1: Int) {

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getItemCount(): Int {
        return 10
    }
}