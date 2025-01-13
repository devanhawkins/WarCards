package com.example.warcards.data

data class Role (
    // TODO : Make class roles for when skills are introduced
    val name: String
)


val jack = Role("Jack")

val queen = Role("Queen")

val king = Role("King")

val joker = Role("Joker")

val roleRoster = listOf(
    com.example.warcards.data.jack,
    com.example.warcards.data.queen,
    com.example.warcards.data.king,
    com.example.warcards.data.joker
)