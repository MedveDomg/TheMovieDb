package omg.medvedomg.labracodetestapp.model

import io.reactivex.Observable
import omg.medvedomg.labracodetestapp.model.data.ListOfPopularMoviesResponse
import omg.medvedomg.labracodetestapp.other.network.Api

/**
 * Created by medvedomg on 04.07.17.
 */
class ApiCommunicateManager(val api: Api) {

    fun getListOfMoviesFromServer(): Observable<ListOfPopularMoviesResponse> {
        return api.getPopularMoviesResponse()
    }

}