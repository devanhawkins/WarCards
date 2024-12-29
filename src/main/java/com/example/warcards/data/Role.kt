package com.example.warcards.data

data class Role (
    // TODO : Make class roles for when skills are introduced
    val name: String,
    val description: String,
    val skill: () -> Unit
)
