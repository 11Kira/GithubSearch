package com.test.githubsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.githubsearch.databinding.ListItemRepositoriesBinding

/**
 * Adapter class for repository list
 */
class RepoListAdapter : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    lateinit var binding: ListItemRepositoriesBinding

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_repositories,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    inner class ViewHolder(
        val binding: ListItemRepositoriesBinding
    ) : RecyclerView.ViewHolder(binding.root)
}