package id.asad.movie2.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.asad.movie2.databinding.FragmentTvshowBinding
import id.asad.movie2.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var binding : FragmentTvshowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTvshowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()

            binding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShows().observe(viewLifecycleOwner, Observer {
                binding.progressBar.visibility = View.GONE
                tvShowAdapter.setTvShow(it)
                tvShowAdapter.notifyDataSetChanged()
            })

            with(binding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }
}