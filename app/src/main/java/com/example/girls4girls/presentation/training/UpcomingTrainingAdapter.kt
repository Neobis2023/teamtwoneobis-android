package com.example.girls4girls.presentation.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.girls4girls.R
import com.example.girls4girls.data.model.Data
import com.example.girls4girls.data.repository.Training
import com.example.girls4girls.databinding.ItemUpcomingTrainingBinding
import com.example.girls4girls.utils.toFormattedDate
import java.text.SimpleDateFormat
import java.util.*

class UpcomingTrainingAdapter : RecyclerView.Adapter<UpcomingTrainingAdapter.ViewHolder>() {

    private lateinit var binding: ItemUpcomingTrainingBinding

    /**
     * DiffUtil -> calculates differences between two lists and enables us to only update
     * to those items that are different.
     *
     * To start we need callback for our async list differ
     *
     *
     */

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemUpcomingTrainingBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val training = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(training.images[0].url).into(binding.ivTrainingImage)
            binding.tvTrainingTitle.text = training.title
            binding.tvDate.text = training.eventDate.toFormattedDate()
            binding.tvLocation.text = training.address
            binding.tvTime.text = training.time
            binding.tvDeadline.text = training.deadlineDate.toFormattedDate()
            setOnClickListener {
                onItemClickListener?.let { it(training) }
            }
        }
    }

    private var onItemClickListener: ((Data) -> Unit)? = null

    fun setOnItemClickListener(listener: (Data) -> Unit) {
        onItemClickListener = listener
    }
}