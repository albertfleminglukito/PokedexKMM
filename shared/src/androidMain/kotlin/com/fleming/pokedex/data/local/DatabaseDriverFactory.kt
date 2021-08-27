package com.fleming.pokedex.data.local

import android.content.Context
import com.fleming.pokedex.base.ContextArgs
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(PokemonDatabase.Schema, context, "PokemonDatabase.db")
    }
}

actual fun getSqlDriver(contextArgs: ContextArgs?): SqlDriver {
    return AndroidSqliteDriver(PokemonDatabase.Schema, contextArgs?.mContext!!, "PokemonDatabase.db")
}
