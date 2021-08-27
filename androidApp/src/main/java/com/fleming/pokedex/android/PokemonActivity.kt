package com.fleming.pokedex.android

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fleming.pokedex.android.databinding.ActivityPokemonBinding
import com.fleming.pokedex.domain.viewparam.PokemonViewParam
import com.fleming.pokedex.presentation.PokemonViewState.SuccessGetState
import com.fleming.pokedex.presentation.PokemonViewState.ErrorState
import com.fleming.pokedex.presentation.PokemonViewState.LoadingState
import com.fleming.pokedex.presentation.PokemonViewModel
import com.fleming.pokedex.presentation.PokemonViewModelContract
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.instance

class PokemonActivity : AppCompatActivity(), DIAware {

    override val di by lazy { (application as PokedexApplication).di }
    override val diTrigger = DITrigger()

    private lateinit var mBinding: ActivityPokemonBinding
    private val mViewModel: PokemonViewModelContract by instance()
    private val pokemonId: String by lazy { intent.getStringExtra(EXTRA_ID).orEmpty() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        diTrigger.trigger()

        observeViewModel()
        mViewModel.getPokemonList(pokemonId)
    }

    private fun observeViewModel() {
        mViewModel.mPokemonLiveData.addObserver {
            when (it) {
                is LoadingState -> showLoading(true)
                is SuccessGetState -> setPokemonData(it.pokemon)
                is ErrorState -> showError()
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        mBinding.pbLoading.visibility = if (isLoading) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun setPokemonData(pokemon: PokemonViewParam) {
        showLoading(false)
        with(mBinding) {
            Glide.with(this@PokemonActivity).asBitmap().load(pokemon.sprite).into(ivSprite)
            tvName.text = pokemon.name
            tvHeight.text = pokemon.height.toString()
            tvWeight.text = pokemon.weight.toString()
        }
    }

    private fun showError() {
        showLoading(false)
        AlertDialog.Builder(this)
            .setTitle("Load Error")
            .setMessage("There is an error when fetch data, try again?")
            .setPositiveButton("Yes") { _, _ -> mViewModel.getPokemonList(pokemonId) }
            .setNegativeButton("No") { _, _ -> finish() }
            .show()
    }

    companion object {
        private const val EXTRA_ID = "id"
        fun newInstance(context: Context, id: String) {
            context.startActivity(Intent(context, PokemonActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            })
        }
    }
}

