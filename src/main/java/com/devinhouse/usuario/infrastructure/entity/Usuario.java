package com.devinhouse.usuario.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //aponta ao spring que essa é uma tabela do banco de dados
@Table(name = "usuario") //indica o nome da tabela
@Builder
public class Usuario implements UserDetails {  // gerenciador de acessos

    @Id //identificador único
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera automáticamente os Id
    private Long id;
    @Column(name = "nome", length = 100) //identifica os parametrôs da coluna
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;
    //criando anotações para fazer relacionamento de tabelas endereços mais telefone
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Endereco> enderecos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
