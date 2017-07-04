package omg.medvedomg.labracodetestapp.other.network

import io.reactivex.Observable
import omg.medvedomg.labracodetestapp.model.data.ListOfPopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by medvedomg on 04.07.17.
 */
interface Api {

    @GET("movie/popular")
    fun getPopularMoviesResponse(@Query("api_key") apiKey: String = "73ca768a64e4fb7f37e044d22a437a93",
                                 @Query("page") page: String = "1"): Observable<ListOfPopularMoviesResponse>
}