package id.asad.movie2.testing

import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.data.remote.ResultsItemTvShow

object FakeDataDummy {

    fun generateRemoteDummyMovies(): List<ResultsItemMovie> {

        val movies = ArrayList<ResultsItemMovie>()
        movies.add(
            ResultsItemMovie(
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",
                "en",
                "Fast & Furious Presents: Hobbs & Shaw",
                false,
                "Fast & Furious Presents: Hobbs & Shaw",
                 arrayListOf(2),
                "/hpgda6P9GutvdkDX5MUJ92QG9aj.jpg",
                "/hpgda6P9GutvdkDX5MUJ92QG9aj.jpg",
                "2019-08-01",
                6.6,
                415.96,
                384018,
                false,
                591
            )
        )
        return movies
    }

    fun generateRemoteDummyTvShow() : List<ResultsItemTvShow>{

        val tvshow = ArrayList<ResultsItemTvShow>()
        tvshow.add(
            ResultsItemTvShow(
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "en",
                 arrayListOf(2),
                "/fki3kBlwJzFp8QohL43g9ReV455.jpg",
                 arrayListOf("ID"),
                "/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg",
                "The Flash",
                255.792,
                6.6,
                "The Flash",
                60735,
                2785
            )
        )

        return tvshow
    }

}