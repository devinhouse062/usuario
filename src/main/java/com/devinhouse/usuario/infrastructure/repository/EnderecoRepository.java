package com.devinhouse.usuario.infrastructure.repository;

import com.devinhouse.ApredendoSpring.infraestructore.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
