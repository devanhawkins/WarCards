package com.example.warcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.warcards.data.gameModes
import com.example.warcards.data.noFaceCards
import com.example.warcards.ui.BattleScreen
import com.example.warcards.ui.theme.WarCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WarCardsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->



                    // For now, start right into the battle screen
                    val deck = noFaceCards.card.shuffled()
                    val gameType = gameModes.doubleDeck
                    BattleScreen(
                        deck,
                        gameType,
                        modifier = Modifier.padding(innerPadding))


                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WarCardsTheme {
        Greeting("Android")
    }
}