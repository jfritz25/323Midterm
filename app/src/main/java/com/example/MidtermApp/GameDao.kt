package com.example.MidtermApp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameDao {
    /**
     * Used as the interface working with the database to insert, delete and update the main data
     * table holding the notes present
     *
     */
    @Insert
    suspend fun insert(score: Score):Long
    @Update
    suspend fun update(score: Score)
    @Delete
    suspend fun delete(score: Score)
    @Query("SELECT * FROM scores_table WHERE scoreId = :key")
    fun get(key: Long): LiveData<Score>
    @Query("SELECT * FROM scores_table ORDER BY scoreId DESC")
    fun getAll(): LiveData<List<Score>>


}