package com.fleming.pokedex.data.local.dao

import com.fleming.pokedex.base.ContextArgs
import com.fleming.pokedex.data.local.Database
import com.fleming.pokedex.data.local.DatabaseCreator
import com.fleming.pokedex.data.local.PokemonList
import com.fleming.pokedex.data.model.PokemonListResponse

class PokedexListDaoImpl(contextArgs: ContextArgs?) : PokedexListDao {

    private var mDatabase: Database = DatabaseCreator.getDataBase(contextArgs)

    override suspend fun getPokemonList(): List<PokemonList> {
        return mDatabase.getAllPokemonList()
    }

    override suspend fun insertPokemonList(list: List<PokemonListResponse.Pokemon>) {
        mDatabase.insertPokemonList(list)
    }

    override suspend fun deleteAllPokemonList() {
        mDatabase.clearPokemonList()
    }
}