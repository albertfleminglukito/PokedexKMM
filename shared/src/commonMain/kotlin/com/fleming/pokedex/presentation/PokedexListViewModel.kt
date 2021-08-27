package com.fleming.pokedex.presentation

import com.fleming.pokedex.base.Result
import com.fleming.pokedex.domain.interactor.PokedexInteractor
import com.fleming.pokedex.presentation.PokedexListViewState.LoadingState
import com.fleming.pokedex.presentation.PokedexListViewState.SuccessGetState
import com.fleming.pokedex.presentation.PokedexListViewState.ErrorState
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class PokedexListViewModel(
    override val di: DI
) : ViewModel(), DIAware, PokedexListViewModelContract {

    private val interactor: PokedexInteractor by instance()

    override var mPokedexListLiveData =
        MutableLiveData<PokedexListViewState>(LoadingState())

    override fun getPokemonList() = viewModelScope.launch {
        mPokedexListLiveData.postValue(LoadingState())

        val response = interactor.getPokemonList(10, 0)
        val value = if (response is Result.Success) {
            SuccessGetState(response.data.results)
        } else {
            ErrorState()
        }
        mPokedexListLiveData.postValue(value)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
