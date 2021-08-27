package com.fleming.pokedex.data.local

import com.fleming.pokedex.data.model.PokemonListResponse
import com.squareup.sqldelight.db.SqlDriver

class Database(sqlDriver: SqlDriver) {
    private val database = PokemonDatabase(sqlDriver)
    private val dbQuery = database.pokemonDatabaseQueries

    fun clearPokemonList() {
        dbQuery.transaction {
            dbQuery.removeAllPokemonList()
        }
    }

    fun getAllPokemonList(): List<PokemonList> {
        return dbQuery.selectAllPokemonList().executeAsList()
    }

    fun insertPokemonList(list: List<PokemonListResponse.Pokemon>) {
        database.transaction {
            for (pokemon in list) {
                dbQuery.insertPokemonList(name = pokemon.name, url = pokemon.url)
            }
        }
    }
}