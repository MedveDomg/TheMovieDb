package omg.medvedomg.labracodetestapp.model.data

import com.google.gson.annotations.SerializedName

/**
 * Created by medvedomg on 04.07.17.
 */

//all models are situated in this class

data class ListOfPopularMoviesResponse(
        @SerializedName("page")
        val page: Int?,
        @SerializedName("total_results")
        val totalResults: Int?,
        @SerializedName("total_pages")
        val totalPages: Int?,
        @SerializedName("results")
        var movies: List<Movie>
)

data class Movie(
        @SerializedName("vote_count")
        val voteCount: Int?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("video")
        val video: Boolean?,
        @SerializedName("vote_average")
        val voteAverage: Double?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("popularity")
        val popularity: Double?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("original_language")
        val originalLanguage: String?,
        @SerializedName("original_title")
        val originalTitle: String?,
        @SerializedName("genre_ids")
        val genreIds: List<Int>,
        @SerializedName("backdrop_path")
        val backdropPath: String?,
        @SerializedName("adult")
        val adult: Boolean?,
        @SerializedName("overview")
        val overview: String?,
        @SerializedName("release_date")
        val release_date: String?,
        @SerializedName("budget")
        val budget: String?,
        @SerializedName("homepage")
        val link: String?,
        var categories: String?
)

data class CategoriesOfMoviesResponse(
        @SerializedName("genres")
        var categories: List<Category>
)

data class Category(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?
)