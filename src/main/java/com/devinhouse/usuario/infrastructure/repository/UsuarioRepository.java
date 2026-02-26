package com.devinhouse.usuario.infrastructure.repository;


import com.devinhouse.usuario.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository //para o spring saber que é um repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email); //Optional em java evita que caso o resultado seja null o código não quebre

    @Transactional
    void deleteByEmail(String email);
}
