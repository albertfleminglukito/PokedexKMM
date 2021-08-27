package com.fleming.pokedex.presentation

import dev.icerock.moko.mvvm.livedata.MutableLiveData
import kotlinx.coroutines.Job

interface PokemonViewModelContract {

    var mPokemonLiveData: MutableLiveData<PokemonViewState>

    fun getPokemonList(id: String): Job

}