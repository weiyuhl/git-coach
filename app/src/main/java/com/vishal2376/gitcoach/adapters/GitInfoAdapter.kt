package com.vishal2376.gitcoach.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.vishal2376.gitcoach.R
import com.vishal2376.gitcoach.models.GitCommandItem

class GitInfoAdapter(
    private val context: Context,
    private val gitCommandList: List<GitCommandItem>
) :
    Adapter<GitInfoAdapter.GitInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.git_info_item, parent, false)
        return GitInfoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gitCommandList.size
    }

    override fun onBindViewHolder(holder: GitInfoViewHolder, position: Int) {

        //set data
        val currentGitInfo = gitCommandList[position]
        holder.name.text = currentGitInfo.name
        holder.command.text = currentGitInfo.command
        holder.description.text = currentGitInfo.description

        //animation
        holder.itemView.animation = AnimationUtils.loadAnimation(context, R.anim.popup_anim)

    }

    inner class GitInfoViewHolder(itemView: View) : ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvGitName)
        val command: TextView = itemView.findViewById(R.id.tvGitCommand)
        val description: TextView = itemView.findViewById(R.id.tvGitDescription)
    }
}