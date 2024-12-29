package com.example.warcards.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.warcards.data.Card
import com.example.warcards.data.CardImage

@Composable
fun BattleScreen(player1Card: Card,
              player2Card: Card,
              player1Score: Int,
              player2Score: Int,
              cardsRemaining: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Player cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CardImage(card = player1Card)
            CardImage(card = player2Card)
        }

        // Scores
        Spacer(modifier = Modifier.height(16.dp))
        Text("Player 1: $player1Score")
        Text("Player 2: $player2Score")

        // Cards remaining
        Spacer(modifier = Modifier.height(16.dp))
        Text("Cards Remaining: $cardsRemaining")
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBattleScreen() {
    val player1Card = Card(1, "Ace of Hearts", "Heart", false)
    val player2Card = Card(5, "Five of Hearts", "Club", false)

    WarCardsTheme {

        BattleScreen(player1Card, player2Card, 10, 5, 52)
    }

}