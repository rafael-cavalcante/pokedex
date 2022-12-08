package br.com.rafaelcavalcante.pokedex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelcavalcante.pokedex.model.Pokemon;
import br.com.rafaelcavalcante.pokedex.repository.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public void salvar(Pokemon pokemon) {
        this.pokemonRepository.save(pokemon);
    }

    public Pokemon buscarId(Long id) {
        return this.pokemonRepository.findById(id).orElse(null);
    }

    public void deletarId(Long id){
        this.pokemonRepository.deleteById(id);
    }
}
