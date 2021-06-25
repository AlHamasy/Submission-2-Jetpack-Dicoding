package id.asad.movie2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.app.ShareCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.data.remote.ResultsItemTvShow
import id.asad.movie2.databinding.ActivityDetailContentBinding
import id.asad.movie2.viewmodel.ViewModelFactory

class DetailContentActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_CONTENT = "extra_content"
        const val CONTENT_CODE = "content_code"
    }

    private lateinit var binding : ActivityDetailContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailContentViewModel::class.java]

        val code = intent.getIntExtra(CONTENT_CODE, 0)

        if (code == 1){
            val extras = intent.extras
            if (extras != null){
                showLoading(true)
                val id = extras.getInt(EXTRA_CONTENT)
                viewModel.setSelectedMovie(id)
                viewModel.getSelectedMovie().observe(this, Observer {
                    showLoading(false)
                    populateContentMovie(it)
                })
            }
        }
        else if (code == 2){
            val extras = intent.extras
            if (extras != null){
                showLoading(true)
                val id = extras.getInt(EXTRA_CONTENT)
                viewModel.setSelectedTvShow(id)
                viewModel.getSelectedTvShow().observe(this, Observer {
                    showLoading(false)
                    populateContentTvShow(it)
                })
            }
        }


    }

    private fun populateContentTvShow(content: ResultsItemTvShow?){
        Glide.with(this).load("https://image.tmdb.org/t/p/w500${content?.posterPath}").into(binding.imgPoster)
        binding.tvTitle.text = content?.name
        binding.tvVoteAverage.text = "${content?.voteAverage}"
        binding.tvOverview.text = content?.overview
        binding.tvReleaseDate.text = content?.firstAirDate
        binding.fabShare.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Bagikan konten ini sekarang.")
                    .setText(content?.name)
                    .startChooser()
        }
    }

    private fun populateContentMovie(content: ResultsItemMovie?){
        Glide.with(this).load("https://image.tmdb.org/t/p/w500${content?.posterPath}").into(binding.imgPoster)
        binding.tvTitle.text = content?.title
        binding.tvVoteAverage.text = "${content?.voteAverage}"
        binding.tvOverview.text = content?.overview
        binding.tvReleaseDate.text = content?.releaseDate
        binding.fabShare.setOnClickListener {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Bagikan konten ini sekarang.")
                .setText(content?.title)
                .startChooser()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showLoading(show : Boolean){
        if (show){
            binding.tvTitle.visibility = View.GONE
            binding.tvVoteAverage.visibility = View.GONE
            binding.tvOverview.visibility = View.GONE
            binding.tvReleaseDate.visibility = View.GONE
            binding.fabShare.visibility = View.GONE
            binding.imgPoster.visibility = View.GONE
            binding.tvOverviewLabel.visibility = View.GONE
            binding.tvVoteAvarageLabel.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }
        else{
            binding.tvTitle.visibility = View.VISIBLE
            binding.tvVoteAverage.visibility = View.VISIBLE
            binding.tvOverview.visibility = View.VISIBLE
            binding.tvReleaseDate.visibility = View.VISIBLE
            binding.fabShare.visibility = View.VISIBLE
            binding.imgPoster.visibility = View.VISIBLE
            binding.tvOverviewLabel.visibility = View.VISIBLE
            binding.tvVoteAvarageLabel.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }
}