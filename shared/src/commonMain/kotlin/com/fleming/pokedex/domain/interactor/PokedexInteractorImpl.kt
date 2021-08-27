package com.fleming.pokedex.domain.interactor

import com.fleming.pokedex.base.Result
import com.fleming.pokedex.domain.datasource.PokedexDataSource
import com.fleming.pokedex.domain.viewparam.PokemonListViewParam

class PokedexInteractorImpl(private val dataSource: PokedexDataSource) : PokedexInteractor {

    override suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListViewParam> {
        return try {
            val response = dataSource.getPokemonList(limit, offset)
            if (response is Result.Success) {
                Result.Success(PokemonListViewParam(response.data))
            } else {
                Result.Error(Throwable())
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}
