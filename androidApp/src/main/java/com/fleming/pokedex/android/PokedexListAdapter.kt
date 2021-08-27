package com.fleming.pokedex.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fleming.pokedex.android.databinding.ItemPokemonListBinding
import com.fleming.pokedex.domain.viewparam.PokemonListViewParam

class PokedexListAdapter(
    private val listener: PokedexListListener
) : ListAdapter<PokemonListViewParam.Pokemon, PokedexListViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexListViewHolder {
        return PokedexListViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: PokedexListViewHolder, position: Int) {
        holder.bind(currentList[position], listener)
    }

}

interface PokedexListListener {
    fun onPokedexItemClick(id: String)
}

class PokedexListViewHolder(
    private val binding: ItemPokemonListBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup): PokedexListViewHolder {
            return PokedexListViewHolder(
                ItemPokemonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    fun bind(data: PokemonListViewParam.Pokemon, listener: PokedexListListener) {
        with(binding) {
            tvPokemon.text = data.name
            itemView.setOnClickListener {
                listener.onPokedexItemClick(data.name)
            }
        }
    }

}

class PokemonDiffCallback : DiffUtil.ItemCallback<PokemonListViewParam.Pokemon>() {

    override fun areItemsTheSame(
        oldItem: PokemonListViewParam.Pokemon,
        newItem: PokemonListViewParam.Pokemon
    ): Boolean {
        return newItem === oldItem
    }

    override fun areContentsTheSame(
        oldItem: PokemonListViewParam.Pokemon,
        newItem: PokemonListViewParam.Pokemon
    ): Boolean {
        return newItem == oldItem
    }
}