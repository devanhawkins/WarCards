package com.example.warcards.data

data class Deck(
    val card: List<Card>
) {
    fun shuffle(): Deck {
        return Deck(card.shuffled())
    }

    fun first(): Card {
        return card.first()
    }

    fun drop(n: Int): Deck {
        return Deck(card.drop(n))
    }

    fun chunked(n: Int): List<Deck> {
        return card.chunked(n).map { Deck(it) }
    }
}

val regularDeckWithJoker = Deck(
    listOf(
        Card(1, "Ace of Hearts", "Heart", false),
        Card(2, "Two of Hearts", "Heart", false),
        Card(3, "Three of Hearts", "Heart", false),
        Card(4, "Four of Hearts", "Heart", false),
        Card(5, "Five of Hearts", "Heart", false),
        Card(6, "Six of Hearts", "Heart", false),
        Card(7, "Seven of Hearts", "Heart", false),
        Card(8, "Eight of Hearts", "Heart", false),
        Card(9, "Nine of Hearts", "Heart", false),
        Card(10, "Ten of Hearts", "Heart", false),
        Card(11, "Jack of Hearts", "Heart", true),
        Card(12, "Queen of Hearts", "Heart", true),
        Card(13, "King of Hearts", "Heart", true),
        Card(1, "Ace of Clubs", "Club", false),
        Card(2, "Two of Clubs", "Club", false),
        Card(3, "Three of Clubs", "Club", false),
        Card(4, "Four of Clubs", "Club", false),
        Card(5, "Five of Clubs", "Club", false),
        Card(6, "Six of Clubs", "Club", false),
        Card(7, "Seven of Clubs", "Club", false),
        Card(8, "Eight of Clubs", "Club", false),
        Card(9, "Nine of Clubs", "Club", false),
        Card(10, "Ten of Clubs", "Club", false),
        Card(11, "Jack of Clubs", "Club", true),
        Card(12, "Queen of Clubs", "Club", true),
        Card(13, "King of Clubs", "Club", true),
        Card(1, "Ace of Diamonds", "Diamond", false),
        Card(2, "Two of Diamonds", "Diamond", false),
        Card(3, "Three of Diamonds", "Diamond", false),
        Card(4, "Four of Diamonds", "Diamond", false),
        Card(5, "Five of Diamonds", "Diamond", false),
        Card(6, "Six of Diamonds", "Diamond", false),
        Card(7, "Seven of Diamonds", "Diamond", false),
        Card(8, "Eight of Diamonds", "Diamond", false),
        Card(9, "Nine of Diamonds", "Diamond", false),
        Card(10, "Ten of Diamonds", "Diamond", false),
        Card(11, "Jack of Diamonds", "Diamond", true),
        Card(12, "Queen of Diamonds", "Diamond", true),
        Card(13, "King of Diamonds", "Diamond", true),
        Card(1, "Ace of Spades", "Spade", false),
        Card(2, "Two of Spades", "Spade", false),
        Card(3, "Three of Spades", "Spade", false),
        Card(4, "Four of Spades", "Spade", false),
        Card(5, "Five of Spades", "Spade", false),
        Card(6, "Six of Spades", "Spade", false),
        Card(7, "Seven of Spades", "Spade", false),
        Card(8, "Eight of Spades", "Spade", false),
        Card(9, "Nine of Spades", "Spade", false),
        Card(10, "Ten of Spades", "Spade", false),
        Card(11, "Jack of Spades", "Spade", true),
        Card(12, "Queen of Spades", "Spade", true),
        Card(13, "King of Spades", "Spade", true),
        Card(0, "Red Joker", "Joker", true),
        Card(0, "Black Joker", "Joker", true)
    )
)

val regularDeckNoJoker = Deck(
    listOf(
        Card(1, "Ace of Hearts", "Heart", false),
        Card(2, "Two of Hearts", "Heart", false),
        Card(3, "Three of Hearts", "Heart", false),
        Card(4, "Four of Hearts", "Heart", false),
        Card(5, "Five of Hearts", "Heart", false),
        Card(6, "Six of Hearts", "Heart", false),
        Card(7, "Seven of Hearts", "Heart", false),
        Card(8, "Eight of Hearts", "Heart", false),
        Card(9, "Nine of Hearts", "Heart", false),
        Card(10, "Ten of Hearts", "Heart", false),
        Card(11, "Jack of Hearts", "Heart", false),
        Card(12, "Queen of Hearts", "Heart", false),
        Card(13, "King of Hearts", "Heart", false),
        Card(1, "Ace of Clubs", "Club", false),
        Card(2, "Two of Clubs", "Club", false),
        Card(3, "Three of Clubs", "Club", false),
        Card(4, "Four of Clubs", "Club", false),
        Card(5, "Five of Clubs", "Club", false),
        Card(6, "Six of Clubs", "Club", false),
        Card(7, "Seven of Clubs", "Club", false),
        Card(8, "Eight of Clubs", "Club", false),
        Card(9, "Nine of Clubs", "Club", false),
        Card(10, "Ten of Clubs", "Club", false),
        Card(11, "Jack of Clubs", "Club", false),
        Card(12, "Queen of Clubs", "Club", false),
        Card(13, "King of Clubs", "Club", false),
        Card(1, "Ace of Diamonds", "Diamond", false),
        Card(2, "Two of Diamonds", "Diamond", false),
        Card(3, "Three of Diamonds", "Diamond", false),
        Card(4, "Four of Diamonds", "Diamond", false),
        Card(5, "Five of Diamonds", "Diamond", false),
        Card(6, "Six of Diamonds", "Diamond", false),
        Card(7, "Seven of Diamonds", "Diamond", false),
        Card(8, "Eight of Diamonds", "Diamond", false),
        Card(9, "Nine of Diamonds", "Diamond", false),
        Card(10, "Ten of Diamonds", "Diamond", false),
        Card(11, "Jack of Diamonds", "Diamond", false),
        Card(12, "Queen of Diamonds", "Diamond", false),
        Card(13, "King of Diamonds", "Diamond", false),
        Card(1, "Ace of Spades", "Spade", false),
        Card(2, "Two of Spades", "Spade", false),
        Card(3, "Three of Spades", "Spade", false),
        Card(4, "Four of Spades", "Spade", false),
        Card(5, "Five of Spades", "Spade", false),
        Card(6, "Six of Spades", "Spade", false),
        Card(7, "Seven of Spades", "Spade", false),
        Card(8, "Eight of Spades", "Spade", false),
        Card(9, "Nine of Spades", "Spade", false),
        Card(10, "Ten of Spades", "Spade", false),
        Card(11, "Jack of Spades", "Spade", false),
        Card(12, "Queen of Spades", "Spade", false),
        Card(13, "King of Spades", "Spade", false),
    )
)


// The deck for the no face card version of war
val noFaceCards = Deck(
    listOf(Card(1, "Ace of Hearts", "Heart", false),
        Card(2, "Two of Hearts", "Heart", false),
        Card(3, "Three of Hearts", "Heart", false),
        Card(4, "Four of Hearts", "Heart", false),
        Card(5, "Five of Hearts", "Heart", false),
        Card(6, "Six of Hearts", "Heart", false),
        Card(7, "Seven of Hearts", "Heart", false),
        Card(8, "Eight of Hearts", "Heart", false),
        Card(9, "Nine of Hearts", "Heart", false),
        Card(10, "Ten of Hearts", "Heart", false),
        Card(1, "Ace of Clubs", "Club", false),
        Card(2, "Two of Clubs", "Club", false),
        Card(3, "Three of Clubs", "Club", false),
        Card(4, "Four of Clubs", "Club", false),
        Card(5, "Five of Clubs", "Club", false),
        Card(6, "Six of Clubs", "Club", false),
        Card(7, "Seven of Clubs", "Club", false),
        Card(8, "Eight of Clubs", "Club", false),
        Card(9, "Nine of Clubs", "Club", false),
        Card(10, "Ten of Clubs", "Club", false),
        Card(1, "Ace of Diamonds", "Diamond", false),
        Card(2, "Two of Diamonds", "Diamond", false),
        Card(3, "Three of Diamonds", "Diamond", false),
        Card(4, "Four of Diamonds", "Diamond", false),
        Card(5, "Five of Diamonds", "Diamond", false),
        Card(6, "Six of Diamonds", "Diamond", false),
        Card(7, "Seven of Diamonds", "Diamond", false),
        Card(8, "Eight of Diamonds", "Diamond", false),
        Card(9, "Nine of Diamonds", "Diamond", false),
        Card(10, "Ten of Diamonds", "Diamond", false),
        Card(1, "Ace of Spades", "Spade", false),
        Card(2, "Two of Spades", "Spade", false),
        Card(3, "Three of Spades", "Spade", false),
        Card(4, "Four of Spades", "Spade", false),
        Card(5, "Five of Spades", "Spade", false),
        Card(6, "Six of Spades", "Spade", false),
        Card(7, "Seven of Spades", "Spade", false),
        Card(8, "Eight of Spades", "Spade", false),
        Card(9, "Nine of Spades", "Spade", false),
        Card(10, "Ten of Spades", "Spade", false)
    )
)
