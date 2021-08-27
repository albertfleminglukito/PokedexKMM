package com.fleming.pokedex.data.local

import com.fleming.pokedex.base.ContextArgs
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(PokemonDatabase.Schema, "PokemonDatabase.db")
    }
}

actual fun getSqlDriver(contextArgs: ContextArgs?): SqlDriver {
    return NativeSqliteDriver(PokemonDatabase.Schema, "PokemonDatabase.db")
}