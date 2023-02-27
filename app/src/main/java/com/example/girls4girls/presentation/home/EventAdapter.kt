package com.example.girls4girls.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.girls4girls.R
import com.example.girls4girls.data.Event
import com.example.girls4girls.data.VideoBlog
import com.example.girls4girls.databinding.ItemEventBinding
import com.example.girls4girls.databinding.ItemVideoblogBinding
import com.example.girls4girls.presentation.videoblogsList.VideoAdapter
import com.example.girls4girls.presentation.videoblogsList.VideoBlogDiffCallback

class EventAdapter: RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private val eventList = listOf(
        Event("Тренинг", "Права женщин","01/03/23", R.drawable.event_1),
        Event("Форум", "Лидерские качества","07/04/23", R.drawable.event_2),
        Event("Тренинг", "Личностный рост","23/06/23", R.drawable.event_3),
        Event("Форум", "Учеба за рубежом","31/12/23", R.drawable.event_4),
    )

    inner class EventViewHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = ItemEventBinding.bind(item)
        fun bind(event: Event) = with(binding){
            Glide.with(binding.root)
                .load(event.image)
                .into(binding.eventImage)
            eventType.text = event.type
            eventName.text = event.title
            eventDate.text = event.date

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventAdapter.EventViewHolder {
        val view = LayoutInflater.from((parent.context)).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventAdapter.EventViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    override fun getItemCount(): Int = eventList.size
}