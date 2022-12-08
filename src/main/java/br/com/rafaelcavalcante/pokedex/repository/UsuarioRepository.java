package br.com.rafaelcavalcante.pokedex.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelcavalcante.pokedex.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    
    public Optional<Usuario> findByUsername(String username);
}
