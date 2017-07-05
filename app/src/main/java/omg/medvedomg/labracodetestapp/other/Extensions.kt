package omg.medvedomg.labracodetestapp.other

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import omg.medvedomg.labracodetestapp.R

/**
 * Created by medvedomg on 04.07.17.
 */
//hack for easier inflating in viewholder
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

//make easier loading image from string
fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context)
                .load(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(this)
    } else {
        Picasso.with(context)
                .load(resources.getString(R.string.image_server_domain).plus(imageUrl))
                .fit()
                .error(R.mipmap.ic_launcher).into(this)
    }
}

