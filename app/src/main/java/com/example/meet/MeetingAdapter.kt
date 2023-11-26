package com.example.meet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.meet.databinding.ItemMeetingBinding

class MeetingAdapter(private val meetingViewModel: MeetingViewModel) :
    ListAdapter<Meeting, MeetingAdapter.MeetingViewHolder>(MeetingDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingViewHolder {
        val binding = ItemMeetingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeetingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeetingViewHolder, position: Int) {
        val currentMeeting = getItem(position)
        holder.bind(currentMeeting)
    }

    inner class MeetingViewHolder(private val binding: ItemMeetingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(meeting: Meeting) {
            binding.textViewMeetingName.text = meeting.name
            binding.textViewScheduledDate.text = meeting.scheduledDate

            // Set up click listeners for the buttons
            binding.buttonEditMeeting.setOnClickListener {
                onEditButtonClick(adapterPosition)
            }

            binding.buttonDeleteMeeting.setOnClickListener {
                onDeleteButtonClick(adapterPosition)
            }
        }
    }

    private class MeetingDiffCallback : DiffUtil.ItemCallback<Meeting>() {
        override fun areItemsTheSame(oldItem: Meeting, newItem: Meeting): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Meeting, newItem: Meeting): Boolean {
            return oldItem == newItem
        }
    }

    // Callbacks to be implemented in the activity or fragment
    var onEditButtonClick: (Int) -> Unit = {}
    var onDeleteButtonClick: (Int) -> Unit = {}
}
