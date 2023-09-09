package com.areeb.moviesexplorer.ui.main.movieslist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.areeb.moviesexplorer.databinding.FragmentMoviesListBinding
import com.areeb.moviesexplorer.extesnion.showLogMessage
import com.areeb.moviesexplorer.ui.main.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesListFragment : BaseFragment<FragmentMoviesListBinding>() {

    private val viewModel : MoviesListViewModel by viewModels()
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMoviesListBinding {
        return FragmentMoviesListBinding.inflate(inflater, container, false)
    }

    override fun onFragmentReady() {

        lifecycleScope.launch {
            viewModel.moviesListState.collect{ state ->
                when (state) {
                    is MoviesListState.Loading -> {
                        // Show loading indicator or handle loading state
                        "Loading = ${state.toString()}".showLogMessage()
                    }
                    is MoviesListState.Success -> {
                        val movies = state.movies
                        // Update UI with the list of movies
                        "movies success = ${movies.size.toString()}".showLogMessage()
                    }
                    is MoviesListState.Error -> {
                        val errorMessage = state.errorMessage
                        // Handle error state, show error message, etc.
                        "movies error = ${errorMessage.toString()}".showLogMessage()
                    }
                }
            }
        }
    }
}
