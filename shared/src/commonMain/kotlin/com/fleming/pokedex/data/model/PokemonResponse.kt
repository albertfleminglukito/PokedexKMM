package com.fleming.pokedex.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable class Ability2 {
    var name: String? = null
    var url: String? = null
}

@Serializable class Ability {
    var ability: Ability? = null
    var is_hidden = false
    var slot = 0
}

@Serializable class Form {
    var name: String? = null
    var url: String? = null
}

@Serializable class Version {
    var name: String? = null
    var url: String? = null
}

@Serializable class GameIndice {
    var game_index = 0
    var version: Version? = null
}

@Serializable class Move2 {
    var name: String? = null
    var url: String? = null
}

@Serializable class MoveLearnMethod {
    var name: String? = null
    var url: String? = null
}

@Serializable class VersionGroup {
    var name: String? = null
    var url: String? = null
}

@Serializable class VersionGroupDetail {
    var level_learned_at = 0
    var move_learn_method: MoveLearnMethod? = null
    var version_group: VersionGroup? = null
}

@Serializable class Move {
    var move: Move? = null
    var version_group_details: List<VersionGroupDetail>? = null
}

@Serializable class Species {
    var name: String? = null
    var url: String? = null
}

@Serializable class DreamWorld {
    var front_default: String? = null
    var front_female: String? = null
}

@Serializable class OfficialArtwork {
    var front_default: String? = null
}

@Serializable class Other {
    var dream_world: DreamWorld? = null

    @SerialName("official-artwork")
    var officialArtwork: OfficialArtwork? = null
}

@Serializable class RedBlue {
    var back_default: String? = null
    var back_gray: String? = null
    var front_default: String? = null
    var front_gray: String? = null
}

@Serializable class Yellow {
    var back_default: String? = null
    var back_gray: String? = null
    var front_default: String? = null
    var front_gray: String? = null
}

@Serializable class GenerationI {
    @SerialName("red-blue")
    var redBlue: RedBlue? = null
    var yellow: Yellow? = null
}

@Serializable class Crystal {
    var back_default: String? = null
    var back_shiny: String? = null
    var front_default: String? = null
    var front_shiny: String? = null
}

@Serializable class Gold {
    var back_default: String? = null
    var back_shiny: String? = null
    var front_default: String? = null
    var front_shiny: String? = null
}

@Serializable class Silver {
    var back_default: String? = null
    var back_shiny: String? = null
    var front_default: String? = null
    var front_shiny: String? = null
}

@Serializable class GenerationIi {
    var crystal: Crystal? = null
    var gold: Gold? = null
    var silver: Silver? = null
}

@Serializable class Emerald {
    var front_default: String? = null
    var front_shiny: String? = null
}

@Serializable class FireredLeafgreen {
    var back_default: String? = null
    var back_shiny: String? = null
    var front_default: String? = null
    var front_shiny: String? = null
}

@Serializable class RubySapphire {
    var back_default: String? = null
    var back_shiny: String? = null
    var front_default: String? = null
    var front_shiny: String? = null
}

@Serializable class GenerationIii {
    var emerald: Emerald? = null

    @SerialName("firered-leafgreen")
    var fireredLeafgreen: FireredLeafgreen? = null

    @SerialName("ruby-sapphire")
    var rubySapphire: RubySapphire? = null
}

@Serializable class DiamondPearl {
    var back_default: String? = null
    var back_female: String? = null
    var back_shiny: String? = null
    var back_shiny_female: String? = null
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
}

@Serializable class HeartgoldSoulsilver {
    var back_default: String? = null
    var back_female: String? = null
    var back_shiny: String? = null
    var back_shiny_female: String? = null
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
}

@Serializable class Platinum {
    var back_default: String? = null
    var back_female: String? = null
    var back_shiny: String? = null
    var back_shiny_female: String? = null
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
}

@Serializable class GenerationIv {
    @SerialName("diamond-pearl")
    var diamondPearl: DiamondPearl? = null

    @SerialName("heartgold-soulsilver")
    var heartgoldSoulsilver: HeartgoldSoulsilver? = null
    var platinum: Platinum? = null
}

@Serializable class Animated {
    var back_default: String? = null
    var back_female: String? = null
    var back_shiny: String? = null
    var back_shiny_female: String? = null
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
}

@Serializable class BlackWhite {
    var animated: Animated? = null
    var back_default: String? = null
    var back_female: String? = null
    var back_shiny: String? = null
    var back_shiny_female: String? = null
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
}

@Serializable class GenerationV {
    @SerialName("black-white")
    var blackWhite: BlackWhite? = null
}

@Serializable class OmegarubyAlphasapphire {
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
}

@Serializable class XY {
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
}

@Serializable class GenerationVi {
    @SerialName("omegaruby-alphasapphire")
    var omegarubyAlphasapphire: OmegarubyAlphasapphire? = null

    @SerialName("x-y")
    var xY: XY? = null
}

@Serializable class Icons {
    var front_default: String? = null
    var front_female: String? = null
}

@Serializable class UltraSunUltraMoon {
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
}

@Serializable class GenerationVii {
    var icons: Icons? = null

    @SerialName("ultra-sun-ultra-moon")
    var ultraSunUltraMoon: UltraSunUltraMoon? = null
}

@Serializable class GenerationViii {
    var icons: Icons? = null
}

@Serializable class Versions {
    @SerialName("generation-i")
    var generationI: GenerationI? = null

    @SerialName("generation-ii")
    var generationIi: GenerationIi? = null

    @SerialName("generation-iii")
    var generationIii: GenerationIii? = null

    @SerialName("generation-iv")
    var generationIv: GenerationIv? = null

    @SerialName("generation-v")
    var generationV: GenerationV? = null

    @SerialName("generation-vi")
    var generationVi: GenerationVi? = null

    @SerialName("generation-vii")
    var generationVii: GenerationVii? = null

    @SerialName("generation-viii")
    var generationViii: GenerationViii? = null
}

@Serializable class Sprites {
    var back_default: String? = null
    var back_female: String? = null
    var back_shiny: String? = null
    var back_shiny_female: String? = null
    var front_default: String? = null
    var front_female: String? = null
    var front_shiny: String? = null
    var front_shiny_female: String? = null
    var other: Other? = null
    var versions: Versions? = null
}

@Serializable class Stat2 {
    var name: String? = null
    var url: String? = null
}

@Serializable class Stat {
    var base_stat = 0
    var effort = 0
    var stat: Stat? = null
}

@Serializable class Type2 {
    var name: String? = null
    var url: String? = null
}

@Serializable class Type {
    var slot = 0
    var type: Type? = null
}

@Serializable class PokemonResponse {
    var abilities: List<Ability>? = null
    var base_experience = 0
    var forms: List<Form>? = null
    var game_indices: List<GameIndice>? = null
    var height = 0
    var held_items: List<String>? = null
    var id = 0
    var is_default = false
    var location_area_encounters: String? = null
    var moves: List<Move>? = null
    var name: String? = null
    var order = 0
    var past_types: List<String>? = null
    var species: Species? = null
    var sprites: Sprites? = null
    var stats: List<Stat>? = null
    var types: List<Type>? = null
    var weight = 0
}


