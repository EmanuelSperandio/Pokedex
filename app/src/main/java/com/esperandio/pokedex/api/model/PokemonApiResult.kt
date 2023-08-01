package com.esperandio.pokedex.api.model

import com.esperandio.pokedex.domain.PokemonSprite

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val sprites: PokemonSprite
)
