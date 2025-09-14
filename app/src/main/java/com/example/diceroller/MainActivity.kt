package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

// MutableIntStateOf stores the int as a primitive vs MutableStateOf stores it as an integer object.

//Dice rolling button
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    //var for roll
    var result  by remember { mutableIntStateOf(1) } //This ensures the value is not reset by the system since its Composable.
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    //Text label that displays the roll number
    var dynamicText by remember { mutableStateOf("Press the Roll button to begin!") }
    //Create a vertical layout
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dynamicText
        )
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        //Creates space between the two UI components
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick =
            { result = (1..6).random()
            dynamicText = "You rolled a $result!"
        }) {
            Text(stringResource(R.string.roll))
        }
    }
}
