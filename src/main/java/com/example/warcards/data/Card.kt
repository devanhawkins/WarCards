package com.example.warcards.data

import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.warcards.R

data class Card(
    val value: Int,
    val name: String,
    val suit: String,
    val isFaceCard: Boolean
)

@Composable
fun CardImage(card: Card, modifier: Modifier = Modifier)  {
    Box(modifier = modifier
        .size(height = 140.dp, width = 100.dp)
        .padding(8.dp)
        .background(Color.Gray)
    ) {
        Column (
            modifier = Modifier.padding(8.dp)
        ){
            Text(text = card.name,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center)
            Icon( ImageVector.vectorResource(id = card.suitIcon()),
                contentDescription = card.name,
                tint = card.iconColor(card),
                modifier = Modifier.padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

    }
}

fun Card.iconColor(card: Card): Color{
    return when(card.suit){
        "Heart" -> Color.Red
        "Club" -> Color.Black
        "Diamond" -> Color.Red
        "Spade" -> Color.Black
        else -> throw IllegalArgumentException("Invalid suit: $card.suit")
    }
}

@Composable
fun Card.suitIcon(): Int {
    return when (this.suit) {
        "Heart" -> R.drawable.baseline_favorite_24
        "Club" -> R.drawable.baseline_cloud_24
        "Diamond" -> R.drawable.baseline_diamond_24
        "Spade" -> R.drawable.baseline_arrow_upward_24
        else -> throw IllegalArgumentException("Invalid suit: $suit")
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCardImage() {
    val card = Card(1, "Ace of Hearts", "Heart", false)
    val card2 = Card(5, "Eight of Diamonds", "Diamond", false)
    Column {
        CardImage(card,
            modifier = Modifier.size(height = 70.dp, width = 50.dp))
        CardImage(card2)
    }

}