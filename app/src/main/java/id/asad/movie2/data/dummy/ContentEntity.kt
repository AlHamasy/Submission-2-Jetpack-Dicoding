package id.asad.movie2.data.dummy

data class ContentEntity(
    var contentId: Int,
    var title: String,
    var overview: String,
    var voteAverage : Int,
    var releaseDate: String,
    var video: Boolean = false,
    var shareLink: String,
    var imagePoster: Int
)