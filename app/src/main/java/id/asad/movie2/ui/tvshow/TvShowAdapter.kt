package id.asad.movie2.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.asad.movie2.data.remote.ResultsItemTvShow
import id.asad.movie2.databinding.ItemContentBinding
import id.asad.movie2.ui.detail.DetailContentActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    private val listTvShow = ArrayList<ResultsItemTvShow?>()

    fun setTvShow(tvShows: List<ResultsItemTvShow?>?){
        if (tvShows == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.MyViewHolder {
        val itemTvShowBinding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MyViewHolder(itemTvShowBinding)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: TvShowAdapter.MyViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    inner class MyViewHolder(private val binding : ItemContentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: ResultsItemTvShow?){
            with(binding){
                tvItemOverview.text = data?.overview
                tvItemReleaseDate.text = data?.firstAirDate
                tvItemTitle.text = data?.name
                Glide.with(itemView).load("https://image.tmdb.org/t/p/w500${data?.posterPath}").into(binding.imgItemPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailContentActivity::class.java)
                    intent.putExtra(DetailContentActivity.CONTENT_CODE, 2)
                    intent.putExtra(DetailContentActivity.EXTRA_CONTENT, data?.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}