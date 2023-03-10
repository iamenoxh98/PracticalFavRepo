package com.example.practicalenoch.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicalenoch.CommitScreenActivity
import com.example.practicalenoch.DetailScreenActivity
import com.example.practicalenoch.R
import com.example.practicalenoch.model.BranchResponseItem

class BranchAdapter(
    private val branchList: List<BranchResponseItem>,
    val context: Context
) :
    RecyclerView.Adapter<BranchAdapter.BranchViewHolder>() {

    class BranchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.branch_data_layout, parent, false)
        return BranchViewHolder(view)
    }

    override fun onBindViewHolder(holder: BranchViewHolder, position: Int) {
        val data: BranchResponseItem = branchList[position]
        holder.name.text = data.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CommitScreenActivity::class.java)
            intent.putExtra("commit_url", data.commit!!.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return branchList.size
    }
}