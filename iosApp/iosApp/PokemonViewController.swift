//
//  PokemonViewController.swift
//  iosApp
//
//  Created by Albert Fleming Lukito on 20/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import shared
import Nuke

class PokemonViewController: UIViewController {
    
    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var textName: UILabel!
    @IBOutlet weak var textHeight: UILabel!
    @IBOutlet weak var textWeight: UILabel!
    
    private let mViewModel: PokemonViewModelContract! = CommonInjector.init().providePokemonVM()
    var id: String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        observeViewModel()
        
        mViewModel.getPokemonList(id: id)
    }
    
    
    private func observeViewModel() {
        mViewModel.mPokemonLiveData.addObserver { (state) in
            if let data = state as? PokemonViewState.SuccessGetState {
                Nuke.loadImage(with: data.pokemon.sprite, into: self.image)
                self.textName.text = data.pokemon.name
                self.textHeight.text = "\(data.pokemon.height)"
                self.textWeight.text = "\(data.pokemon.weight)"
            }
        }
    }
        
}
