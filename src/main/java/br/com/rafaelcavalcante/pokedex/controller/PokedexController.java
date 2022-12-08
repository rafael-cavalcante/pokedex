package br.com.rafaelcavalcante.pokedex.controller;

import java.util.List;

import br.com.rafaelcavalcante.pokedex.model.Pokemon;
import br.com.rafaelcavalcante.pokedex.repository.PokemonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PokedexController {

    private final PokemonRepository pokemonRepository;

    public PokedexController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        List<Pokemon> pokemons = this.pokemonRepository.findAll();
        mav.addObject("pokemons", pokemons);
        return mav;
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("login2")
    private String login2(){
        return "login2";
    }

}
