package id.asad.movie2.data.dummy

import id.asad.movie2.R

object DataDummy {

    fun generateDummyMovies() : List<ContentEntity>{

        val content = ArrayList<ContentEntity>()

        content.add(ContentEntity(
                1,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                75,
                "October 3, 2018",
                false,
                "http://www.themoviedb.org/movie/332562-a-star-is-born",
                R.drawable.poster_movie_a_start_is_born))

        content.add(ContentEntity(
                2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                72,
                "January 31, 2019",
                false,
                "http://www.themoviedb.org/movie/399579-alita-battle-angel",
                R.drawable.poster_movie_alita))

        content.add(ContentEntity(
                3,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                80,
                "October 24, 2018",
                false,
                "http://www.themoviedb.org/movie/424694-bohemian-rhapsody",
                R.drawable.poster_movie_bohemian))

        content.add(ContentEntity(
                4,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                57,
                "February 7, 2019",
                false,
                "http://www.themoviedb.org/movie/438650-cold-pursuit",
                R.drawable.poster_movie_cold_persuit))

        content.add(ContentEntity(
                5,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                69,
                "November 21, 2018",
                false,
                "http://www.themoviedb.org/movie/480530-creed-ii",
                R.drawable.poster_movie_creed))

        content.add(ContentEntity(
                6,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                67,
                "January 16, 2019",
                false,
                "http://www.themoviedb.org/movie/450465-glass",
                R.drawable.poster_movie_glass))

        content.add(ContentEntity(
                7,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                78,
                "January 3, 2019",
                false,
                "http://www.themoviedb.org/movie/166428-how-to-train-your-dragon-the-hidden-world",
                R.drawable.poster_movie_how_to_train))

        content.add(ContentEntity(
                8,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                83,
                "April 25, 2018",
                false,
                "http://www.themoviedb.org/movie/299536-avengers-infinity-war",
                R.drawable.poster_movie_infinity_war))

        content.add(ContentEntity(
                9,
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                61,
                "November 27, 2018",
                false,
                "http://www.themoviedb.org/movie/428078-mortal-engines",
                R.drawable.poster_movie_mortal_engines))

        content.add(ContentEntity(
                10,
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                59,
                "November 21, 2018",
                false,
                "http://www.themoviedb.org/movie/375588-robin-hood",
                R.drawable.poster_movie_robin_hood))

        return content
    }


    fun generateDummyTvshow() : List<ContentEntity>{

        val content = ArrayList<ContentEntity>()

        content.add(ContentEntity(
                11,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                79,
                "March 19, 2021",
                false,
                "http://www.themoviedb.org/tv/88396-the-falcon-and-the-winter-soldier",
                R.drawable.poster_tvshow_falcon))

        content.add(ContentEntity(
                12,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent.",
                77,
                "October 07, 2014",
                false,
                "http://www.themoviedb.org/tv/60735-the-flash",
                R.drawable.poster_tvshow_flash))

        content.add(ContentEntity(
                13,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                86,
                "September 25, 2017",
                false,
                "http://www.themoviedb.org/tv/71712-the-good-doctor",
                R.drawable.poster_tvshow_good_doctor))

        content.add(ContentEntity(
                14,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                75,
                "September 22, 2014",
                false,
                "http://www.themoviedb.org/tv/60708-gotham",
                R.drawable.poster_tvshow_gotham))

        content.add(ContentEntity(
                15,
                "Grey's Anatomy ",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                82,
                "March 27, 2005",
                false,
                "http://www.themoviedb.org/tv/1416-grey-s-anatomy",
                R.drawable.poster_tvshow_grey_anatomy))

        content.add(ContentEntity(
                16,
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                89,
                "March 26, 2021",
                false,
                "http://www.themoviedb.org/tv/95557-invincible",
                R.drawable.poster_tvshow_invincible))

        content.add(ContentEntity(
                17,
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                66,
                "March 17, 2017",
                false,
                "http://www.themoviedb.org/tv/62127-marvel-s-iron-fist",
                R.drawable.poster_tvshow_iron_fist))

        content.add(ContentEntity(
                18,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                85,
                "January 25, 2016",
                false,
                "http://www.themoviedb.org/tv/63174-lucifer",
                R.drawable.poster_tvshow_lucifer))

        content.add(ContentEntity(
                19,
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                86,
                "February 15, 2007",
                false,
                "http://www.themoviedb.org/tv/31910",
                R.drawable.poster_tvshow_naruto_shipudden))

        content.add(ContentEntity(
                20,
                "Who Killed Sara?",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                78,
                "March 24, 2021",
                false,
                "http://www.themoviedb.org/tv/120168-quien-mato-a-sara",
                R.drawable.poster_tvshow_who_killed))

        return content
    }




}