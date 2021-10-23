package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * @author Andres Rubiano Del Chiaro
 */
class ScoreViewModel(
    finalScore: Int
) : ViewModel() {

    var score = finalScore

    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
    }
}