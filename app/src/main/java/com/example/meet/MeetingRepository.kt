package com.example.meet

import androidx.lifecycle.LiveData

class MeetingRepository(private val meetingDao: MeetingDao) {

    val allMeetings: LiveData<List<Meeting>> = meetingDao.getAllMeetings()

    suspend fun addMeeting(meeting: Meeting) {
        meetingDao.addMeeting(meeting)
    }

    suspend fun updateMeeting(meeting: Meeting) {
        meetingDao.updateMeeting(meeting)
    }

    suspend fun deleteMeeting(meeting: Meeting) {
        meetingDao.deleteMeeting(meeting)
    }

    suspend fun deleteAllMeetings() {
        meetingDao.deleteAllMeetings()
    }

    fun getNextMeeting(currentDate: String): LiveData<Meeting?> {
        return meetingDao.getNextMeeting(currentDate)
    }
}
