package id.asad.movie2.data.remote

import com.google.gson.annotations.SerializedName

data class DatesMovie(

	@field:SerializedName("maximum")
	val maximum: String? = null,

	@field:SerializedName("minimum")
	val minimum: String? = null
)