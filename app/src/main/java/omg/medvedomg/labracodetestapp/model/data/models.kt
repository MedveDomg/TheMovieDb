package omg.medvedomg.labracodetestapp.model.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by medvedomg on 04.07.17.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
class ListOfPopularMoviesResponse(
        @JsonProperty("page")
        val page: Int?,
        @JsonProperty("total_results")
        val totalResults: Int?,
        @JsonProperty("total_pages")
        val totalPages: Int?,
        @JsonProperty("results")
        val movies: List<Movie>
)

@JsonIgnoreProperties(ignoreUnknown=true)
class Movie(
        @JsonProperty("vote_count")
        val voteCount: Int?,
        @JsonProperty("id")
        val id: Int?,
        @JsonProperty("video")
        val video: Boolean?,
        @JsonProperty("vote_average")
        val voteAverage: Double?,
        @JsonProperty("title")
        val title: String?,
        @JsonProperty("popularity")
        val popularity: Double?,
        @JsonProperty("poster_path")
        val posterPath: String?,
        @JsonProperty("original_language")
        val originalLanguage: String?,
        @JsonProperty("original_title")
        val originalTitle: String?,
        @JsonProperty("genre_ids")
        val genreIds: List<Int>,
        @JsonProperty("backdrop_path")
        val backdropPath: String?,
        @JsonProperty("adult")
        val adult: Boolean?,
        @JsonProperty("overview")
        val overview: String?,
        @JsonProperty("release_date")
        val release_date: String?
)