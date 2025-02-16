package com.example.bmiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    var bmi: Float = 0.0f
        get() {
            return calculate()
        }

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    fun changeWeightInput(value: String) {
        weightInput = value
    }

    private var height: Float = 0.0f
        get() {
            return heightInput.toFloatOrNull() ?: 0.0f
        }

    private var weight: Float = 0.0f
        get() {
            return weightInput.toFloatOrNull() ?: 0.0f
        }

    private fun calculate(): Float {
        return if (height > 0 && weight > 0) weight / (height * height) else 0.0f
    }
}