package br.com.rafaelcavalcante.pokedex.configuration.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.rafaelcavalcante.pokedex.model.Usuario;
import br.com.rafaelcavalcante.pokedex.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("USUÁRIO NÃO ENCONTRADO: " + username));

        return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true,
                usuario.getAuthorities());
    }

}
