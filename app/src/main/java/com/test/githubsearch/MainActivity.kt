package com.test.githubsearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.githubsearch.databinding.ActivityMainBinding
import com.test.githubsearch.repo.RepoEvent
import com.test.githubsearch.repo.Repository
import com.test.githubsearch.repo.RepositoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Activity class for the repository list
 * @author Julius Villagracia
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var repoListAdapter: RepoListAdapter
    private val viewModel: RepositoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initSearch(binding.searchBox)
        observeSearchResults()
    }

    /**
     * Submits the search query to viewModel
     */
    private fun searchRepositories(query: String) {
        viewModel.searchRepositories(query, "Repositories")
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
        lifecycleScope.launchWhenCreated {
            viewModel.events.observe(this@MainActivity) { event ->
                when (event) {
                    is RepoEvent.OnFinishedLoading -> {
                        initRecyclerView(event.repositories)
                    }
                    is RepoEvent.OnNoAvailable -> {
                        //no available item
                    }
                    is RepoEvent.OnFailedFetching -> {
                        Log.e("ERROR", "error")
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