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
import androidx.navigation.compose.rememberNavController
import com.example.warcards.data.gameModes
import com.example.warcards.data.noFaceCards
import com.example.warcards.navigation.RootNavHost
import com.example.warcards.ui.BattleScreen
import com.example.warcards.ui.StartScreen
import com.example.warcards.ui.theme.WarCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WarCardsTheme {

                val navController = rememberNavController()
                //StartScreen(navController = navController)
                RootNavHost(navController = navController)


            }
        }
    }
}