package com.example.meet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MeetingViewModel(private val repository: MeetingRepository) : ViewModel() {

    val allMeetings = repository.allMeetings

    fun addMeeting(meeting: Meeting) {
        viewModelScope.launch {
            repository.addMeeting(meeting)
        }
    }

    fun updateMeeting(meeting: Meeting) {
        viewModelScope.launch {
            repository.updateMeeting(meeting)
        }
    }

    fun deleteMeeting(meeting: Meeting) {
        viewModelScope.launch {
            repository.deleteMeeting(meeting)
        }
    }

    fun deleteAllMeetings() {
        viewModelScope.launch {
            repository.deleteAllMeetings()
        }
    }

    fun getNextMeeting(currentDate: String) = repository.getNextMeeting(currentDate)
}
