package id.asad.movie2.data.remote

import com.google.gson.annotations.SerializedName

data class TvShowResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItemTvShow?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)