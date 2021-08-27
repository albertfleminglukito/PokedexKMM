package com.fleming.pokedex.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fleming.pokedex.android.databinding.ActivityPokedexListBinding
import com.fleming.pokedex.presentation.PokedexListViewState.SuccessGetState
import com.fleming.pokedex.presentation.PokedexListViewState.ErrorState
import com.fleming.pokedex.presentation.PokedexListViewState.LoadingState
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.fleming.pokedex.domain.viewparam.PokemonListViewParam
import com.fleming.pokedex.presentation.PokedexListViewModelContract
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.instance


class PokedexListActivity : AppCompatActivity(), DIAware, PokedexListListener {

    override val di by lazy { (application as PokedexApplication).di }
    override val diTrigger = DITrigger()

    private lateinit var mBinding: ActivityPokedexListBinding

    private val mViewModel: PokedexListViewModelContract by instance()
    private val mAdapter = PokedexListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPokedexListBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        diTrigger.trigger()

        observeViewModel()
        initView()
        mViewModel.getPokemonList()
    }

    override fun onPokedexItemClick(id: String) {
        PokemonActivity.newInstance(this, id)
    }

    private fun initView() {
        mBinding.rvPokemon.adapter = mAdapter
    }

    private fun observeViewModel() {
        mViewModel.mPokedexListLiveData.addObserver {
            when (it) {
                is LoadingState -> showLoading(true)
                is SuccessGetState -> setPokedexData(it.list)
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

    private fun setPokedexData(pokemonList: List<PokemonListViewParam.Pokemon>) {
        showLoading(false)
        mAdapter.submitList(pokemonList)
    }

    private fun showError() {
        showLoading(false)
        AlertDialog.Builder(this)
            .setTitle("Load Error")
            .setMessage("There is an error when fetch data, try again?")
            .setPositiveButton("Yes") { _, _ -> mViewModel.getPokemonList() }
            .setNegativeButton("No") { _, _ -> finish() }
            .show()
    }
}

