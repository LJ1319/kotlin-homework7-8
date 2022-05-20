package com.example.reqresin.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reqresin.R
import com.example.reqresin.activities.ResourceActivity
import com.example.reqresin.api.dto.Resource

class ResourceRecyclerAdapter(private val resources: List<Resource>) :
    RecyclerView.Adapter<ResourceRecyclerAdapter.ResourceViewHolder>() {

    companion object {
        const val RESOURCE_ID = "RESOURCE_ID"
    }

    class ResourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        private val pantoneView: TextView = itemView.findViewById(R.id.textView5)
        private lateinit var resource: Resource

        fun onBind(resource: Resource) {
            pantoneView.text = resource.pantoneValue
            this.resource = resource
        }

        override fun onClick(clickedView: View?) {
            val context = itemView.context
            val intent = Intent(context, ResourceActivity::class.java)
            intent.putExtra(RESOURCE_ID, resource.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_resource, parent, false)
        return ResourceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        holder.onBind(resources[position])
    }

    override fun getItemCount() = resources.size
}