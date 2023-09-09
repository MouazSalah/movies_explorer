package com.areeb.moviesexplorer.ui.main.movieslist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.areeb.moviesexplorer.BuildConfig
import com.areeb.moviesexplorer.core.BaseAdapter
import com.areeb.moviesexplorer.databinding.ItemMovieBinding
import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import com.bumptech.glide.Glide

class MoviesAdapter(private val onMovieClicked: (MovieResponseItem) -> Unit, private val loadNewPage: () -> Unit) : BaseAdapter<ItemMovieBinding, MovieResponseItem>() {
    override fun createBinding(parent: ViewGroup, viewType: Int) = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    override fun bind(binding: ItemMovieBinding, position: Int) {
        val currentItem = getItem(position)
        binding.apply {

            textViewTitle.text = currentItem.title
            "Release Date: ${currentItem.releaseDate}".also { textViewReleaseDate.text = it }
            "Movie Overview: ${currentItem.overview}".also { textViewOverview.text = it }

            "Popularity: ${currentItem.popularity}".also { textViewPopularity.text = it }
            "Vote Average: ${currentItem.voteAverage}".also { textViewVoteAverage.text = it }

            Glide.with(imageViewPoster.context)
                .load("${BuildConfig.BASE_IMAGES_URL}${currentItem.posterPath}")
                .into(imageViewPoster)

            binding.layoutRoot.setOnClickListener {
                onMovieClicked.invoke(currentItem)
            }

            if (position >= currentList.size - 2) {
                loadNewPage.invoke()
            }
        }
    }
}