package com.example.task.videosScreen.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.databinding.VideosItemBinding

class VideosAdapter : RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    private var videos: List<String> = ArrayList()

    fun setData(videos: List<String>) {
        this.videos = videos

        notifyItemRangeChanged(0,videos.size)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: VideosItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.videos_item, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemBinding.imageUrl = videos[position]

    }

    override fun getItemCount(): Int {
        return videos.size
    }


    class ViewHolder(val itemBinding: VideosItemBinding) : RecyclerView.ViewHolder(itemBinding.root)
}