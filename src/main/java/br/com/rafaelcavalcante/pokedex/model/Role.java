package br.com.rafaelcavalcante.pokedex.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import br.com.rafaelcavalcante.pokedex.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName nome;

    @Override
    public String getAuthority() {
        return this.nome.toString();
    }
}
