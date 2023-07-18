package com.example.jobsmanagement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class JobAdapter(var context: Context, val list: MutableList<Jobs>) : RecyclerView.Adapter<JobAdapter.JobsViewHolder>() {
    class JobsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        return JobsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.job_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        val curJob = list[position]

        holder.itemView.apply {
            title.text = curJob.name
            cbChangeOrder.isChecked = curOrder.isChecked
            setOnClickListener {
                val intent = Intent(context, OrderDetailsActivity::class.java)
                intent.putExtra("listFoods", orders[position].listFood)
                intent.putExtra("idOrder", orders[position].name)
                context.startActivity(intent)
            }
        }

        fun bindData(job: Job) {
            title.text = job.title_text
        }
    }

    override fun getItemCount(): Int = list.size
}