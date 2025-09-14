package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

//Restructuring sample code to start the app theme alignment

//This will be the main function for this app since it only consists of a button and image.
@Composable
@Preview
fun DiceRollerApp(modifier: Modifier = Modifier) {
    //Call to the button and image function
    DiceWithButtonAndImage(modifier = Modifier //Modifier overwrites the default modifier object
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

//Dice rolling button
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

}