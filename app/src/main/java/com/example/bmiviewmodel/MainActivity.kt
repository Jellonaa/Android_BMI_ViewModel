package com.example.bmiviewmodel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmiviewmodel.ui.theme.BMIViewModelTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMIViewModelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    BMI()
                }
            }
        }
    }
}

@Composable
fun BMI(bmiViewModel: BmiViewModel = viewModel()) {

    Column(
        modifier = Modifier.padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = bmiViewModel.heightInput,
            onValueChange = {bmiViewModel.changeHeightInput(it)},
            label = { Text(text = "Height") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        TextField(
            value = bmiViewModel.weightInput,
            onValueChange = {bmiViewModel.changeWeightInput(it)},
            label = { Text(text = "Weight") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Text(
            text = stringResource(R.string.bmi, bmiViewModel.bmi)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMIViewModelTheme {
        BMI()
    }
}