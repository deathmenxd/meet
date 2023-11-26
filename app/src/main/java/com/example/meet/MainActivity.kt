package com.example.meet

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val meetingViewModel: MeetingViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MeetingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding

        // Set up RecyclerView
        adapter = MeetingAdapter(meetingViewModel)
        binding.recyclerViewMeetings.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMeetings.adapter = adapter

        // Observe changes in the list of meetings
        meetingViewModel.allMeetings.observe(this, Observer { meetings ->
            meetings?.let { adapter.submitList(it) }
        })

        // Set up click listeners for buttons
        binding.buttonAddMeeting.setOnClickListener {
            // Handle add meeting button click
            // You can open a new activity or a dialog to add a new meeting
            // For simplicity, let's assume you open a new activity:
            // startActivity(Intent(this, AddMeetingActivity::class.java))
        }

        binding.buttonDeleteAllMeetings.setOnClickListener {
            // Handle delete all meetings button click
            meetingViewModel.deleteAllMeetings()
        }

        // Set up search functionality
        binding.editTextSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val query = binding.editTextSearch.text.toString()
                // Perform search based on the query
                // You can update the ViewModel to handle search functionality
                // meetingViewModel.searchMeetings(query)
                true
            } else {
                false
            }
        }
    }
}
