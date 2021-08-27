package com.fleming.pokedex.data.apiservice

import com.fleming.pokedex.data.model.PokemonListResponse
import com.fleming.pokedex.data.model.PokemonResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import com.fleming.pokedex.base.Result
import io.ktor.client.features.*

class PokedexApiServiceImpl : PokedexApiService {

    private val client = HttpClient {
        install(HttpTimeout) {
            requestTimeoutMillis = 3000
        }
    }
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    override suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListResponse> {
        return try {
            val httpResponse: HttpResponse = client.get("${BASE_URL}pokemon") {
                parameter(limit.toString(), limit)
                parameter(offset.toString(), offset)
            }
            val stringBody: String = httpResponse.receive()
            Result.Success(json.decodeFromString(PokemonListResponse.serializer(), stringBody))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getPokemonDetail(id: String): Result<PokemonResponse> {
        return try {
            val httpResponse: HttpResponse = client.get("${BASE_URL}pokemon/$id")
            val stringBody: String = httpResponse.receive()
            Result.Success(json.decodeFromString(PokemonResponse.serializer(), stringBody))

        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}