package com.areeb.moviesexplorer.ui.main.moviesdetails.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.areeb.moviesexplorer.BuildConfig
import com.areeb.moviesexplorer.R
import com.areeb.moviesexplorer.databinding.FragmentMovieDetailsBinding
import com.areeb.moviesexplorer.extesnion.castToActivity
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.ui.main.base.BaseFragment
import com.areeb.moviesexplorer.ui.main.base.MainActivity
import com.areeb.moviesexplorer.ui.main.moviesdetails.data.MovieDetailsAPIResponse
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {

    private val viewModel : MoviesDetailsViewModel by viewModels()
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMovieDetailsBinding {
        return FragmentMovieDetailsBinding.inflate(inflater, container, false)
    }

    val args: MovieDetailsFragmentArgs by navArgs()

    override fun onFragmentReady() {

        viewModel.getMovieDetails(args.movieId)

        initViews()
        initObservers()

    }

    private fun initViews() {
        binding.apply {

            castToActivity<MainActivity> {

                it?.mBinding?.clToolbar?.isVisible = true

                it?.mBinding?.tvTitle?.text = "Movie Details"

                it?.mBinding?.btnBack?.isVisible = true
                it?.mBinding?.btnBack?.setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().popBackStack()
        }
        callback.isEnabled = true
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.moviesDetailsState.collect{ state ->
                when (state) {
                    is MovieDetailsState.Loading -> { }
                    is MovieDetailsState.Success -> {
                        fillViews(state.movieDetails)
                    }
                    is MovieDetailsState.Error -> {
                        val errorMessage = state.errorMessage
                    }
                }
            }
        }
    }

    private fun fillViews(movieDetails: MovieDetailsAPIResponse?) {

        movieDetails?.let { movieDetails ->
            binding.apply {

                Glide.with(imageViewPoster.context)
                    .load("${BuildConfig.BASE_IMAGES_URL}${movieDetails.posterPath}")
                    .into(imageViewPoster)

                textViewTitle.text = movieDetails.title

                textViewOverview.text = movieDetails.overview

                "Release Date: ${movieDetails.releaseDate}".also { textViewReleaseDate.text = it }

                "Genres: ${movieDetails.genres?.joinToString(", ") { it?.name.orEmpty() }}".also { textViewGenres.text = it }

                "Runtime: ${movieDetails.runtime} minutes".also { textViewRuntime.text = it }

                "IMDb Rating: ${movieDetails.voteAverage}".also { textViewIMDbRating.text = it }

                "Production Companies: ${movieDetails.productionCompanies?.joinToString(", ") { it?.name.orEmpty() }}".also { textViewProductionCompanies.text = it }

                "Production Countries: ${movieDetails.productionCountries?.joinToString(", ") { it?.name.orEmpty() }}".also { textViewProductionCountries.text = it }

                "Status: ${movieDetails.status}".also { textViewStatus.text = it }
            }
        }
    }
}
