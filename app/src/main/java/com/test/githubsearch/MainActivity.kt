package com.test.githubsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.githubsearch.databinding.ActivityMainBinding
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
        searchRepositories()
    }

    private fun searchRepositories() {
        viewModel.searchRepositories("circle", "Repositories")
    }

    /**
     * Initializes the recyclerview and contents
     */
    private fun initRecyclerView() {
        repoListAdapter = RepoListAdapter()
        binding.repoList.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = repoListAdapter
        }
    }

}