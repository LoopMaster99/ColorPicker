package com.practice.colorPicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.colorPicker.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
/*The onCreate() function is the entry point to this
Android app and calls other functions to build the user interface. */
        super.onCreate(savedInstanceState)
        setContent {
//The setContent() function within the onCreate() function
//is used to define your layout through composable function.
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ColorPicker()
                }
            }
        }
    }
}
@Composable
fun ColorPicker(){
    val color = remember{ mutableStateOf(Color.Red) }
    val colorName = remember{ mutableStateOf("Red") }

    Column{
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(color.value)
                .height(150.dp)

        ){
            Text(
                text = "Selected Color: ${colorName.value}",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            ColorButton(color = Color.Red, onClick = {
                color.value = Color.Red
                colorName.value = "Red"
            })
            ColorButton(color = Color.Green, onClick = {
                color.value = Color.Green
                colorName.value = "Green"
            })
            ColorButton(color = Color.Black, onClick = {
                color.value = Color.Black
                colorName.value = "Black"
            })
            ColorButton(color = Color.Blue, onClick = {
                color.value = Color.Blue
                colorName.value = "Blue"
            })
            ColorButton(color = Color.Magenta, onClick = {
                color.value = Color.Magenta
                colorName.value = "Magenta"
            })
            ColorButton(color = Color.Yellow, onClick = {
                color.value = Color.Yellow
                colorName.value = "Yellow"
            })


        }
    }
}
// All functions marked with the @Composable annotation can be
// called from the setContent() function or from other Composable functions.
// The annotation tells the Kotlin compiler that this function
// is used by Jetpack Compose to generate the UI.
@Composable
fun ColorButton(color: Color, onClick: () -> Unit){
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(12.dp)
            .background(color)
            .clickable { onClick() }
            .border(2.dp, Color.Black)
    )
}
// The @Preview annotation tells Android Studio
// that this composable should be shown in the design view of this file.
@Preview(showBackground = true) // adding a background to your composable preview
@Composable
fun GreetingPreview() {
    MyFirstAppTheme {
        ColorPicker()
    }
}
