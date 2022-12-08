package br.com.rafaelcavalcante.pokedex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rafaelcavalcante.pokedex.model.Pokemon;
import br.com.rafaelcavalcante.pokedex.model.Regiao;
import br.com.rafaelcavalcante.pokedex.service.PokemonService;
import br.com.rafaelcavalcante.pokedex.service.RegiaoService;

@Controller
public class PokemonController {

    @Autowired
    private RegiaoService regiaoService;

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemon/cadastrar")
    public ModelAndView getFormCadastro() {
        ModelAndView mav = new ModelAndView("pokemonform");
        List<Regiao> regioes = this.regiaoService.getRegiaoList();
        mav.addObject("regioes", regioes);
        return mav;
    }

    @GetMapping("/pokemon/editar/{id}")
    public ModelAndView editarPokemon(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("pokemonform");
        List<Regiao> regioes = this.regiaoService.getRegiaoList();
        mav.addObject("regioes", regioes);
        Pokemon pokemon = this.pokemonService.buscarId(id);
        mav.addObject("pokemon", pokemon);
        return mav;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/pokemon/deletar/{id}")
    public String deletarPokemon(@PathVariable("id") Long id){
        this.pokemonService.deletarId(id);
        return "redirect:/";
    }

    @PostMapping("/pokemon/cadastrar/salvar")
    public String salvarPokemon(@Valid Pokemon pokemon, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Preencha todos os campos!");
            return "redirect:/pokemon/cadastrar";
        }
        this.pokemonService.salvar(pokemon);
        return "redirect:/";
    }

}
