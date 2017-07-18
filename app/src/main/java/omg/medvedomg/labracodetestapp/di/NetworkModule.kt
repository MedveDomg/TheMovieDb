package omg.medvedomg.labracodetestapp.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import omg.medvedomg.labracodetestapp.other.ApiCommunicateManager
import omg.medvedomg.labracodetestapp.other.network.Api
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

/**
 * Created by medvedomg on 04.07.17.
 */
@Module
class NetworkModule {


    //retrofit instance
    companion object {

//        val URL_BASE = "https://api.themoviedb.org/3/"
//
//        val retrofit = Retrofit.Builder()
//                .baseUrl(URL_BASE)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//        val api = retrofit.create(Api::class.java)

        fun isNetworkConnected(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager// 1
            val networkInfo = connectivityManager.activeNetworkInfo // 2
            return networkInfo != null && networkInfo.isConnected // 3
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

//        val api2 = retrofit.create(Api::class.java)

        return retrofit
//        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : Api{
        return retrofit.create(Api::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideApiManager() : ApiCommunicateManager{
//
//    }

//    @Provides
//    @Singleton
//    fun provideNetwortChecker(context: Application) : Boolean {
//        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager// 1
//        val networkInfo = connectivityManager.activeNetworkInfo // 2
//        return networkInfo != null && networkInfo.isConnected // 3
//    }
}
