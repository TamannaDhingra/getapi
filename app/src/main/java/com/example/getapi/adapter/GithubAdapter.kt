package com.example.getapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getapi.R
import com.example.getapi.model.GithubResponse

class GithubAdapter(private var mlist:List<GithubResponse>):RecyclerView.Adapter<GithubAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title:TextView=itemView.findViewById(R.id.tvtitle)
        val date:TextView=itemView.findViewById(R.id.tv_date)
        val nodeid:TextView=itemView.findViewById(R.id.tv_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_github_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.title.text=mlist[position].title
        holder.date.text=mlist[position].created_at
        holder.nodeid.text=mlist[position].user.node_id
    }

    override fun getItemCount(): Int {
       return mlist.size
    }
}