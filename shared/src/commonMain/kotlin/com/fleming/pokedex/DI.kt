package com.fleming.pokedex

import com.fleming.pokedex.base.ContextArgs
import com.fleming.pokedex.data.apiservice.PokedexApiService
import com.fleming.pokedex.data.apiservice.PokedexApiServiceImpl
import com.fleming.pokedex.data.local.dao.PokedexListDao
import com.fleming.pokedex.data.local.dao.PokedexListDaoImpl
import com.fleming.pokedex.domain.datasource.PokedexDataSource
import com.fleming.pokedex.data.repository.PokedexRepository
import com.fleming.pokedex.domain.interactor.PokedexInteractor
import com.fleming.pokedex.domain.interactor.PokedexInteractorImpl
import com.fleming.pokedex.domain.interactor.PokemonInteractor
import com.fleming.pokedex.domain.interactor.PokemonInteractorImpl
import com.fleming.pokedex.presentation.PokedexListViewModel
import com.fleming.pokedex.presentation.PokedexListViewModelContract
import com.fleming.pokedex.presentation.PokemonViewModel
import com.fleming.pokedex.presentation.PokemonViewModelContract
import org.kodein.di.*
import kotlin.native.concurrent.ThreadLocal

object AppBusiness {
    val pokelistModule = DI.Module("pokelist") {
        bind<PokedexListDao>() with singleton { PokedexListDaoImpl(CommonInjector.mContextArgs) }
        bind<PokedexApiService>() with singleton { PokedexApiServiceImpl() }
        bind<PokedexDataSource>() with singleton { PokedexRepository(instance(), instance()) }
        bind<PokedexInteractor>() with singleton { PokedexInteractorImpl(instance()) }
        bind<PokemonInteractor>() with singleton { PokemonInteractorImpl(instance()) }

        bind<PokedexListViewModelContract>() with provider { PokedexListViewModel(di) }
        bind<PokemonViewModelContract>() with provider { PokemonViewModel(di) }
    }
}

@ThreadLocal
object CommonInjector {
    val kodeinContainer = DI.lazy {
        importAll(AppBusiness.pokelistModule)
    }
    var mContextArgs: ContextArgs? = null

    fun provideContextArgs(contextArgs: ContextArgs): ContextArgs? {
        mContextArgs = contextArgs
        return mContextArgs
    }

    // Direct access to the presenters
    fun providePokedexListVM() = kodeinContainer.direct.instance<PokedexListViewModelContract>()
    fun providePokemonVM() = kodeinContainer.direct.instance<PokemonViewModelContract>()
}