package com.test.githubsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.test.githubsearch.databinding.ListItemRepositoriesBinding
import com.test.githubsearch.repo.Repository
import com.test.githubsearch.utils.ConversionUtil

/**
 * Adapter class for repository list
 * @author Julius Villagracia
 */
class RepoListAdapter(
    private var repoList: List<Repository>
) : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    lateinit var binding: ListItemRepositoriesBinding

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (itemCount > 0) {
            val repo = repoList[position]
            holder.apply {
                binding.repoNameTxt.text = repo.fullName
                binding.descTxt.text = repo.description
                binding.languageTxt.text = repo.language
                binding.stargazerTxt.text = ConversionUtil.formatLargeNumber(repo.stargazersCount)
                binding.ownerImg.load(repo.owner?.avatarUrl) {
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_background)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return repoList.size
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