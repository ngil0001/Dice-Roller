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

//Dice rolling button
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    //Create a vertical layout
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.dice_1),
            contentDescription = "1"
        )
        //Creates space between the two UI components
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /*TODO*/}) {
            Text(stringResource(R.string.roll))
        }
    }
}