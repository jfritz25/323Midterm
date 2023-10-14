package com.example.MidtermApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel() : ViewModel() {
    /**
     * NotesViewModel's purpose is to get the data from the database and to communicate to the
     * dao to either insert, delete or update the data passed into the function
     *
     * @param dao the database we are working with
     * return calls to dao on the required command (insert, delete, update)
     * */
    private val _navigateToGame = MutableLiveData<Long?>()
    val navigateToGame: LiveData<Long?>
        get() = _navigateToGame

    private val _navigateToHighScore = MutableLiveData<Long?>()
    val navigateToHighScore: LiveData<Long?>
        get() = _navigateToHighScore
    fun onPlayClicked() {
        _navigateToGame.value = 1
    }

    fun onHighScoreClicked() {
        _navigateToHighScore.value = null
    }
}