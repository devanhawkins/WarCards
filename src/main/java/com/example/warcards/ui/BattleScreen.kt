package com.example.warcards.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.warcards.R
import com.example.warcards.data.Card
import com.example.warcards.data.CardImage
import com.example.warcards.data.Deck
import com.example.warcards.data.Role
import com.example.warcards.data.gameModes
import com.example.warcards.data.noFaceCards
import com.example.warcards.data.regularDeckNoJoker
import com.example.warcards.navigation.NavigationDestination
import com.example.warcards.ui.theme.WarCardsTheme

object BattleDestination: NavigationDestination {
    override val route = "battle"
    const val mode = "mode"
    val routeWithArgs = "$route/{$mode}"
}

@Composable
fun BattleScreen(
    navController: NavHostController,
    gameMode: String
) {

    // Set-up using data from saved state
    val deckType = when (gameMode) {
        "regular" -> regularDeckNoJoker.card
        "doubleDeck" -> regularDeckNoJoker.card
        "roleplay" -> noFaceCards.card
        else -> regularDeckNoJoker.card
    }

    // Variables
    // New decks for the game
    var playerDeck by remember { mutableStateOf(Deck(deckType).shuffle()) }
    var computerDeck by remember { mutableStateOf(Deck(deckType).shuffle()) }

    // Player cards
    var playerCard by remember { mutableStateOf(playerDeck.first()) }
    var computerCard by remember { mutableStateOf(computerDeck.first()) }

    // Score for the game
    var playerScore by remember { mutableIntStateOf(0) }
    var computerScore by remember { mutableIntStateOf(0) }

    // Additional state variables
    var cardsRemaining by remember { mutableIntStateOf(playerDeck.card.size) }
    var isGameOver by remember { mutableStateOf(false) }
    var winner by remember { mutableIntStateOf(0) }
    var drawContinuation by remember { mutableIntStateOf(0) }
    var hasStarted by remember { mutableStateOf(false) }
    var isShowingRemainingCards = remember { mutableStateOf(false) }


    fun addDrawPoints(winner: Int){
        if (winner == 1) {
            playerScore += drawContinuation
            drawContinuation = 0
        } else if (winner == -1) {
            computerScore += drawContinuation
            drawContinuation = 0
        }
    }

    fun splitDeck(oneDeck: List<Card>) {
        val half = oneDeck.size / 2
        val shuffled = oneDeck.shuffled()
        playerDeck = Deck(shuffled).chunked(half)[0]
        computerDeck = Deck(shuffled).chunked(half)[1]
        cardsRemaining = half
    }

    fun standardStart(){
        splitDeck(deckType)
        playerCard = playerDeck.first()
        computerCard = computerDeck.first()
    }
    
    fun standardWarTurn() {
        if (cardsRemaining == 0) {
            isGameOver = true
        }

        if (!isGameOver) {
            // Draw card for battle
            playerCard = playerDeck.first()
            playerDeck = playerDeck.drop(1)

            computerCard = computerDeck.first()
            computerDeck = computerDeck.drop(1)

            // Check who won
            winner = checkWin(playerCard, computerCard)
            if (winner == 0) {
                drawContinuation++
            } else if (winner == 1) {
                playerScore++
                addDrawPoints(winner)
            } else if (winner == -1) {
                computerScore++
                addDrawPoints(winner)
            }

            // Update remaining cards
            cardsRemaining--

        } else {
            // Do nothing...
        }
    }

    fun restart(){
        playerDeck = Deck(noFaceCards.card.shuffled())
        computerDeck = Deck(noFaceCards.card.shuffled())
        playerCard = playerDeck.first()
        computerCard = computerDeck.first()
        playerScore = 0
        computerScore = 0
        cardsRemaining = playerDeck.card.size
        isGameOver = false
        winner = 0
        hasStarted = false
        drawContinuation = 0
    }
    

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Player cards

            if (hasStarted) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(1f)
                            .fillMaxWidth(0.5f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (winner == 1) {
                            Icon(
                                imageVector =
                                ImageVector.vectorResource(id = R.drawable.baseline_sentiment_very_satisfied_24),
                                contentDescription = "winner icon",
                                tint = Color.Green
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(1f)
                            .fillMaxWidth(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (winner == -1) {
                            Icon(
                                imageVector =
                                ImageVector.vectorResource(id = R.drawable.baseline_sentiment_very_satisfied_24),
                                contentDescription = "winner icon",
                                tint = Color.Green
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(1f)
                            .fillMaxWidth(0.5f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Player",
                            modifier = Modifier.width(IntrinsicSize.Max))
                        CardImage(card = playerCard,
                            modifier = Modifier
                                .size(height = 210.dp, width = 150.dp)
                                .fillMaxHeight()
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight(1f)
                            .fillMaxWidth(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Opponent",
                            modifier = Modifier.width(IntrinsicSize.Max),)
                        CardImage(
                            card = computerCard,
                            modifier = Modifier
                                .size(height = 210.dp, width = 150.dp)
                                .fillMaxHeight()
                        )
                    }
    
                }
            }

            // Scores
            Spacer(modifier = Modifier.height(16.dp))
            Text("Player 1: $playerScore")
            Text("Player 2: $computerScore")

            // Cards remaining
            Spacer(modifier = Modifier.height(16.dp))
            Text("Cards Remaining: $cardsRemaining")

            // Game over
            if (isGameOver) {
                Spacer(modifier = Modifier.height(16.dp))
                var winText = ""
                if (playerScore > computerScore){
                    winText = "You win!"
                } else if (playerScore < computerScore){
                    winText = "You lose!"
                } else {
                    winText = "It's a draw!"
                }
                Text(winText)
                Button(onClick = {
                    restart()
                }){
                    Text("Play Again")
                }

            }

            // Buttons
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                if (hasStarted) {
                    standardWarTurn()
                } else {
                    // Start game
                    hasStarted = true
                    playerDeck.shuffle()
                    computerDeck.shuffle()

                    // Choose start by game type
                    if (gameMode == gameModes.regular){
                        standardStart()
                    }
                    standardWarTurn()
                }
            }) {
                if (hasStarted){
                    Text("Next Battle")
                }else{
                    Text("Start Battle")
                }
            }

            Button(onClick = { isShowingRemainingCards.value = true }) {
                Text("Show Remaining Cards")
            }

            // Popup for showing list of remaining cards in deck
            if (isShowingRemainingCards.value) {
                ShowRemainingCards(playerDeck, noFaceCards, isShowingRemainingCards)
            }
        }
    }
}

fun checkWin(playerCard: Card, computerCard: Card): Int{
    return if (playerCard.value > computerCard.value) {
        1
    } else if (playerCard.value < computerCard.value) {
        -1
    } else {
        0
    }
}

fun getCardColor(currentCard: Card, fullDeck: Deck): Color {
    if (currentCard in fullDeck.card) {
        return Color.Green
    } else {
        return Color.Red
    }
}

@Composable
fun ShowRemainingCards(currentDeck: Deck, fullDeck: Deck, showPopup: MutableState<Boolean>){
    Popup(onDismissRequest = { showPopup.value = false }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(16.dp)
        ){
            Column (modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Text(text = "Remaining Cards",
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center)

                for (card in fullDeck.card){
                    Text(text = card.name,
                        color = getCardColor(card, currentDeck),
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewBattleScreen() {
    //val player1Card = Card(1, "Ace of Hearts", "Heart", false)
    //val player2Card = Card(5, "Five of Hearts", "Club", false)
    //val player1Deck = Deck(listOf(player1Card))
    //val player2Deck = Deck(listOf(player2Card))

    WarCardsTheme {

        val navController = rememberNavController()
        BattleScreen(
            navController = navController,
            gameMode = "Regular"
        )
    }

}
