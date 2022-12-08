package br.com.rafaelcavalcante.pokedex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelcavalcante.pokedex.model.Regiao;
import br.com.rafaelcavalcante.pokedex.repository.RegiaoRepository;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;
    
    public List<Regiao> getRegiaoList(){
        return this.regiaoRepository.findAll();
    }
}
