package com.test.githubsearch.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.githubsearch.R
import com.test.githubsearch.core.base.BaseActivity
import com.test.githubsearch.databinding.ActivityMainBinding
import com.test.githubsearch.model.Repository
import com.test.githubsearch.repo.RepoState
import com.test.githubsearch.repo.RepositoryViewModel
import com.test.githubsearch.utils.NetworkUtil
import kotlinx.coroutines.launch

/**
 * Activity class for the repository list
 * @author Julius Villagracia
 */
class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var repoListAdapter: RepoListAdapter
    private val viewModel: RepositoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initSearch(binding.searchBox)
        observeSearchResults()
    }

    /**
     * Submits the search query to viewModel
     * @param the search query to be submitted to API
     */
    private fun searchRepositories(query: String) {
        NetworkUtil.checkInternetConnectivity(this)
        {
            viewModel.searchRepositories(query, "Repositories")
        }
    }

    /**
     * Initializes the recyclerview and contents
     * @param repoList The repository list
     */
    private fun initRecyclerView(repoList: List<Repository>) {
        repoListAdapter = RepoListAdapter(repoList)
        binding.repoList.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = repoListAdapter
        }
        repoListAdapter.onItemClick = { repository ->
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(repository.htmlUrl)
            })
        }
    }

    /**
     * Observes the search results livedata
     */
    private fun observeSearchResults() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.repoState.collect { state ->
                    when (state) {
                        is RepoState.SetResults -> {
                            initRecyclerView(state.repoList)
                        }
                        is RepoState.ShowError -> {
                            Log.e("Error: ", state.error.toString())
                        }
                        else -> {
                            Log.e("Error: ", state.toString())

                        }
                    }
                }
            }
        }
    }

    /**
     * Setup search functionalities
     * @param searchBox The edittext to be used
     */
    private fun initSearch(searchBox: AppCompatEditText) {
        searchBox.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s != null && s.toString().trim().isNotBlank()) {
                    val txt = s.toString().trim()
                    searchRepositories(txt)
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // do nothing
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // do nothing
            }
        })
    }

}