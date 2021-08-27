package com.fleming.pokedex.presentation

import com.fleming.pokedex.domain.viewparam.PokemonListViewParam
import com.fleming.pokedex.domain.viewparam.PokemonViewParam

sealed class PokedexListViewState {

    class LoadingState: PokedexListViewState()
    class SuccessGetState(val list: List<PokemonListViewParam.Pokemon>): PokedexListViewState()
    class ErrorState: PokedexListViewState()

}

sealed class PokemonViewState {

    class LoadingState: PokemonViewState()
    class SuccessGetState(val pokemon: PokemonViewParam): PokemonViewState()
    class ErrorState: PokemonViewState()

}

