package com.test.githubsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.githubsearch.databinding.ActivityMainBinding

/**
 * Activity class for the repository list
 * @author Julius Villagracia
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var repoListAdapter: RepoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
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