package com.example.defendher // Replace with your actual package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.defendher.ui.theme.DefendHerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefendHerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0AFFF))
    ) {
        // Header
        Column(modifier = Modifier.fillMaxSize()) {
            TopBar()
            Spacer(modifier = Modifier.height(20.dp))
            ButtonsSection()
        }
        SOSButton(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Handle menu */ }) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "Andria Jacob Toms",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Kochi, Kerala",
                style = TextStyle(color = Color.White, fontSize = 16.sp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.icons8_profile_picture_96), // Add a profile image in your drawable folder
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, shape = CircleShape)
        )
    }
}

@Composable
fun ButtonsSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        listOf("Travel Tracker", "Safe Drive", "Safe Rest").forEach { buttonText ->
            Button(
                onClick = { /* Navigate to respective screen */ },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFB388FF)
                )
            ) {
                Text(
                    text = buttonText,
                    style = TextStyle(color = Color.White, fontSize = 18.sp)
                )
            }
        }
    }
}

@Composable
fun SOSButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /* Trigger SOS Alert */ },
        modifier = modifier
            .padding(16.dp)
            .size(80.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFFF5252)
        )
    ) {
        Text(
            text = "SOS",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
    }
}
