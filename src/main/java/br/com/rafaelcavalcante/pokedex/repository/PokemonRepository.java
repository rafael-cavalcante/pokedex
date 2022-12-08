package br.com.rafaelcavalcante.pokedex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelcavalcante.pokedex.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    public Optional<Pokemon> findById(Long id);
}
