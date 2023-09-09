package com.areeb.moviesexplorer.ui.main.movieslist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.areeb.moviesexplorer.R
import com.areeb.moviesexplorer.databinding.FragmentMoviesListBinding
import com.areeb.moviesexplorer.extesnion.castToActivity
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.ui.main.base.BaseFragment
import com.areeb.moviesexplorer.ui.main.base.MainActivity
import com.areeb.moviesexplorer.ui.main.movieslist.data.MovieResponseItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesListFragment : BaseFragment<FragmentMoviesListBinding>() {

    private val moviesAdapter by lazy { MoviesAdapter(::onMovieClicked, ::onLoadNewPage) }
    private val viewModel : MoviesListViewModel by viewModels()
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMoviesListBinding {
        return FragmentMoviesListBinding.inflate(inflater, container, false)
    }

    override fun onFragmentReady() {

        initViews()
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.moviesListState.collect{ state ->
                when (state) {
                    MoviesListState.Loading -> {
                        binding.rvMovies.isVisible = false
                        binding.shimmerLayout.isVisible = true
                    }
                    is MoviesListState.Success -> {
                        binding.rvMovies.isVisible = true
                        binding.shimmerLayout.isVisible = false

                        val movies = state.movies
                        when (viewModel.moviesListParams.page) {
                            1 -> {
                                moviesAdapter.setList(movies)
                            }
                            else -> {
                                moviesAdapter.updateList(movies)
                            }
                        }
                    }
                    is MoviesListState.Error -> {
                        val errorMessage = state.errorMessage
                    }
                }
            }
        }
    }

    private fun initViews() {

        binding.apply {

            rvMovies.adapter = moviesAdapter

            castToActivity<MainActivity> {

                it?.mBinding?.apply {
                    clToolbar.isVisible = true
                    tvTitle.text = "Movies"
                    btnBack.isVisible = false
                }
            }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finishAffinity()
        }
        callback.isEnabled = true
    }


    private fun onMovieClicked(movie: MovieResponseItem) {
        val args = Bundle()
        args.putString("movieId", movie.id.toString())
        findNavController().navigate(R.id.action_moviesList_to_movieDetail, args)
    }

    private fun onLoadNewPage() {
        when {
            (viewModel.moviesListParams.page ?: 1) < viewModel.totalPages -> {
                viewModel.moviesListParams.page = viewModel.moviesListParams.page?.plus(1)
                viewModel.fetchMovies()
            }
        }
    }
}
