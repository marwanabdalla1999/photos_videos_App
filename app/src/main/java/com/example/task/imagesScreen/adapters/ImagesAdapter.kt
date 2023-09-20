package com.example.task.imagesScreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.databinding.ImageItemBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {

    private var images: List<String> = ArrayList()

    fun setData(images: List<String>) {
        this.images = images

        notifyItemRangeChanged(0, images.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ImageItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.image_item, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.imageUrl = images[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)

}