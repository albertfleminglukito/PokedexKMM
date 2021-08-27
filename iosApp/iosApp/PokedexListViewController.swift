//
//  PokedexListViewController.swift
//  iosApp
//
//  Created by Albert Fleming Lukito on 16/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import shared

class PokedexListViewController: UIViewController {
    
    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var loadingBar: UIActivityIndicatorView!
    
    var items:[PokemonListViewParam.Pokemon] = []
    
    let mViewModel: PokedexListViewModelContract! = CommonInjector.init().providePokedexListVM()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        initView()
        observeViewModel()
        mViewModel.getPokemonList()
    }
    
    private func initView() {
        self.tableView.register(UITableViewCell.self, forCellReuseIdentifier: "cell")
        self.tableView.dataSource = self
        self.tableView.delegate = self
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "pokemon") {
            if let viewController = segue.destination as? PokemonViewController {
                if let index = self.tableView.indexPathForSelectedRow?.row {
                    viewController.id = self.items[index].name
                }
            }
        }
    }
    
    private func observeViewModel() {
        mViewModel.mPokedexListLiveData.addObserver { (state) in
            switch state {
            case is PokedexListViewState.LoadingState: self.showLoading(true)
            case is PokedexListViewState.SuccessGetState: self.setPokedexData(state as! PokedexListViewState.SuccessGetState)
            default: self.showError()
            }
        }
    }
    
    private func showLoading(_ isLoading: Bool) {
        loadingBar.isHidden = !isLoading
        
    }

    private func setPokedexData(_ state: PokedexListViewState.SuccessGetState) {
        showLoading(false)
        self.items = state.list
        self.tableView.reloadData()
    }

    private func showError() {
        showLoading(false)
        let alert = UIAlertController(title: "Load Error", message: "There is an error when fetch data, try again?", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Yes", style: .default, handler: { action in
            if (action.style == .default) {
                self.mViewModel.getPokemonList()
            }
        }))
        self.present(alert, animated: true, completion: nil)
    }
    
    
}

extension PokedexListViewController: UITableViewDelegate, UITableViewDataSource{
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return items.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath);
        cell.textLabel?.text = items[indexPath.row].name
        return cell;
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        self.performSegue(withIdentifier: "pokemon", sender: indexPath)
    }
}
