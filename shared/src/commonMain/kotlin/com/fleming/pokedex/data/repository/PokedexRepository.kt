package com.fleming.pokedex.data.repository

import com.fleming.pokedex.base.Result
import com.fleming.pokedex.data.apiservice.PokedexApiService
import com.fleming.pokedex.data.local.dao.PokedexListDao
import com.fleming.pokedex.domain.datasource.PokedexDataSource
import com.fleming.pokedex.data.model.PokemonListResponse
import com.fleming.pokedex.data.model.PokemonResponse

class PokedexRepository(
    private val dao: PokedexListDao,
    private val apiService: PokedexApiService
) : PokedexDataSource {

    override suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListResponse> {
        var result = apiService.getPokemonList(limit, offset)
        if (result is Result.Success) {
            dao.deleteAllPokemonList()
            dao.insertPokemonList(result.data.results)
        } else {
            val list = dao.getPokemonList().map { PokemonListResponse.Pokemon(it.name, it.url) }
            if (list.isNotEmpty()) {
                result = Result.Success(PokemonListResponse(count = list.size, results = list))
            }
        }
        return result
    }

    override suspend fun getPokemonDetail(id: String): Result<PokemonResponse> {
        return apiService.getPokemonDetail(id)
    }

}
