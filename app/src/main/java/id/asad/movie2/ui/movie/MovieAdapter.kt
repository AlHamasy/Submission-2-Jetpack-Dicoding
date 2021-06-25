package id.asad.movie2.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.asad.movie2.data.remote.ResultsItemMovie
import id.asad.movie2.databinding.ItemContentBinding
import id.asad.movie2.ui.detail.DetailContentActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private val listMovie = ArrayList<ResultsItemMovie?>()

    fun setMovies(movies: List<ResultsItemMovie?>?){
        if (movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyViewHolder {
        val itemMovieBinding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(itemMovieBinding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieAdapter.MyViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    inner class MyViewHolder(private val binding : ItemContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResultsItemMovie?){
            with(binding){
                tvItemOverview.text = data?.overview
                tvItemReleaseDate.text = data?.releaseDate
                tvItemTitle.text = data?.title
                Glide.with(itemView).load("https://image.tmdb.org/t/p/w500${data?.posterPath}").into(binding.imgItemPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailContentActivity::class.java)
                    intent.putExtra(DetailContentActivity.CONTENT_CODE, 1)
                    intent.putExtra(DetailContentActivity.EXTRA_CONTENT, data?.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}