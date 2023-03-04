package com.example.sm_david_androidpemula.kantincoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sm_david_androidpemula.R


class AcademyAdapter(private val listAcademy: ArrayList<Academy>) :

    RecyclerView.Adapter<AcademyAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_academy, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, rate, photo, overview) = listAcademy[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvItemName.text = name
        holder.tvItemRate.text = rate
        holder.tvItemOverview.text = overview

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listAcademy[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listAcademy.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgPhoto: ImageView = itemView.findViewById(R.id.img_academy)
        val tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvItemRate: TextView = itemView.findViewById(R.id.tv_item_rate)
        val tvItemOverview: TextView = itemView.findViewById(R.id.tv_item_overview)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Academy)
    }
}