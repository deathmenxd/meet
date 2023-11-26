package com.example.meet

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MeetingDao {
    @Query("SELECT * FROM meetings")
    fun getAllMeetings(): LiveData<List<Meeting>>

    @Query("SELECT * FROM meetings WHERE scheduledDate >= :currentDate ORDER BY scheduledDate ASC LIMIT 1")
    fun getNextMeeting(currentDate: String): LiveData<List<Meeting>>

    @Insert
    suspend fun addMeeting(meeting: Meeting)

    @Update
    suspend fun updateMeeting(meeting: Meeting)

    @Delete
    suspend fun deleteMeeting(meeting: Meeting)

    @Query("DELETE FROM meetings")
    suspend fun deleteAllMeetings()
}

