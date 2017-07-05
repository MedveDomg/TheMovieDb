package omg.medvedomg.labracodetestapp.other.network

import android.content.Context
import android.net.ConnectivityManager
import android.util.Base64
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import omg.medvedomg.labracodetestapp.R
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.jackson.JacksonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Created by medvedomg on 04.07.17.
 */
class NetworkUtil {


    //retrofit instance
    companion object {

        val URL_BASE = "https://api.themoviedb.org/3/"

        val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(Api::class.java)

        fun isNetworkConnected(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager// 1
            val networkInfo = connectivityManager.activeNetworkInfo // 2
            return networkInfo != null && networkInfo.isConnected // 3
        }
    }


}
