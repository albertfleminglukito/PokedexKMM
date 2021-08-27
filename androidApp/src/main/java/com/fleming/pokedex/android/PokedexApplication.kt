package com.fleming.pokedex.android

import android.app.Application
import com.fleming.pokedex.AppBusiness
import com.fleming.pokedex.CommonInjector
import com.fleming.pokedex.base.ContextArgs
import org.kodein.di.DI
import org.kodein.di.DIAware

class PokedexApplication: Application(), DIAware {

    override val di = CommonInjector.kodeinContainer

    override fun onCreate() {
        super.onCreate()
        CommonInjector.provideContextArgs(ContextArgs(this))
    }

}