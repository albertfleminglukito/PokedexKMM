package com.fleming.pokedex.presentation

import com.fleming.pokedex.base.Result
import com.fleming.pokedex.domain.interactor.PokemonInteractor
import com.fleming.pokedex.presentation.PokemonViewState.LoadingState
import com.fleming.pokedex.presentation.PokemonViewState.SuccessGetState
import com.fleming.pokedex.presentation.PokemonViewState.ErrorState
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class PokemonViewModel(
    override val di: DI
) : ViewModel(), DIAware, PokemonViewModelContract {

    private val interactor: PokemonInteractor by instance()

    override var mPokemonLiveData = MutableLiveData<PokemonViewState>(LoadingState())

    override fun getPokemonList(id: String) = viewModelScope.launch {
        mPokemonLiveData.postValue(LoadingState())

        val response = interactor.getPokemonDetail(id)
        val value = if (response is Result.Success) {
            SuccessGetState(response.data)
        } else {
            ErrorState()
        }
        mPokemonLiveData.postValue(value)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}