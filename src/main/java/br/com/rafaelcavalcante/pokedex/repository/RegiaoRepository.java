package br.com.rafaelcavalcante.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelcavalcante.pokedex.model.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {
    
}
