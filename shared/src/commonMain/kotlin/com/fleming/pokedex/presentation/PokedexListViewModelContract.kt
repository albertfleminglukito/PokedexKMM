package com.fleming.pokedex.presentation

import dev.icerock.moko.mvvm.livedata.MutableLiveData
import kotlinx.coroutines.Job

interface PokedexListViewModelContract {

    var mPokedexListLiveData: MutableLiveData<PokedexListViewState>

    fun getPokemonList(): Job

}