package com.example.laboratorio11b.model

data class PokemonResponse(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>
)