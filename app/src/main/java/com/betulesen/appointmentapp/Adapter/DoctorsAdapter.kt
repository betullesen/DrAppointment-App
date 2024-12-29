package com.betulesen.appointmentapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.betulesen.appointmentapp.Activity.DetailActivity
import com.betulesen.appointmentapp.Model.DoctorsModel
import com.betulesen.appointmentapp.databinding.ViewholderDoctorsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

class DoctorsAdapter(val items:MutableList<DoctorsModel>):RecyclerView.Adapter<DoctorsAdapter.ViewHolder>() {

    private var context: Context? = null

    class ViewHolder(val binding:ViewholderDoctorsBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsAdapter.ViewHolder {
        context=parent.context
        return ViewHolder(ViewholderDoctorsBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: DoctorsAdapter.ViewHolder, position: Int) {
        holder.binding.nameText.text = items[position].Name
        holder.binding.specialityyText.text = items[position].Special
        holder.binding.costText.text = items[position].Cost

        Glide.with(holder.itemView.context)
            .load(items[position].Picture)
            .apply { RequestOptions().transform(CenterCrop()) }
            .into((holder.binding.img))

        holder.binding.root.setOnClickListener{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("object",items[position])
            context?.startActivity(intent)
        }

    }
    override fun getItemCount(): Int = items.size

}