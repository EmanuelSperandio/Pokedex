package com.esperandio.pokedex.domain

data class Pokemon(
    val id: Int,
    val name: String,
    val sprite: PokemonSprite
    )
{
    val formattedNumber = id.toString().padStart(3,'0')
}
