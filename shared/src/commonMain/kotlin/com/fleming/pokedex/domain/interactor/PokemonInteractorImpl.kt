package com.fleming.pokedex.domain.interactor

import com.fleming.pokedex.base.Result
import com.fleming.pokedex.domain.datasource.PokedexDataSource
import com.fleming.pokedex.domain.viewparam.PokemonViewParam

class PokemonInteractorImpl(private val dataSource: PokedexDataSource): PokemonInteractor {

    override suspend fun getPokemonDetail(id: String): Result<PokemonViewParam> {
        return try {
            val response = dataSource.getPokemonDetail(id)
            if (response is Result.Success) {
                Result.Success(PokemonViewParam(response.data))
            } else {
                Result.Error(Throwable())
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}
