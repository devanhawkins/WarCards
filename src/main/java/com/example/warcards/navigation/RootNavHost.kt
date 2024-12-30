package com.example.warcards.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.warcards.data.gameModes
import com.example.warcards.ui.BattleDestination
import com.example.warcards.ui.BattleScreen
import com.example.warcards.ui.StartScreen

@Composable
fun RootNavHost(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = "start")
    {
        // Start Screen Navigation
        composable("start"){
            StartScreen(
                navController,
                navigateToRegularBattle = {
                    navController.navigate("battle/regular")
                },
                navigateToDoubleDeckBattle = {
                    navController.navigate("battle/doubleDeck")
                },
                navigateToRoleplayBattle = {
                    navController.navigate("battle/roleplay")
                }
            )
        }

        // Battle Navigation
        composable(route = "battle/regular") {
            BattleScreen(
                navController,
                gameMode = gameModes.regular
            )
        }

        composable(route = "battle/doubleDeck") {
            BattleScreen(
                navController,
                gameMode = gameModes.doubleDeck
            )
        }

        composable(route = "battle/roleplay") {
            BattleScreen(
                navController,
                gameMode = gameModes.roleplay
            )
        }

    }
}