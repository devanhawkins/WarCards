package com.example.warcards.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.warcards.data.gameModes
import com.example.warcards.ui.theme.WarCardsTheme

@Composable
fun StartScreen(navController: NavController = rememberNavController(),
                navigateToRegularBattle: (String) -> Unit = {},
                navigateToDoubleDeckBattle: (String) -> Unit = {},
                navigateToRoleplayBattle: (String) -> Unit = {}
){
    WarCardsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
            {
                // Title
                Text(text = "War Cards")
                
                // Game Mode Buttons
                // Regular
                Button(onClick = { navigateToRegularBattle(gameModes.regular) }) {
                    Text(text = gameModes.regular)
                }
                Spacer(modifier = Modifier.height(8.dp))
                
                // Double Deck
                Button(onClick = { navigateToDoubleDeckBattle(gameModes.doubleDeck) }) {
                    Text(text = gameModes.doubleDeck)
                }
                Spacer(modifier = Modifier.height(8.dp))
                
                // Role play
                Button(onClick = { navigateToRoleplayBattle(gameModes.roleplay) }) {
                    Text(text = gameModes.roleplay)
                }
                Spacer(modifier = Modifier.height(8.dp))
                
                
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun StartScreenPreview(){
    WarCardsTheme {
        val navController = rememberNavController()
        StartScreen(navController)
    }
}