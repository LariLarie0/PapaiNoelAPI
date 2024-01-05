package com.example.rec.cidadeEstado;

import com.example.rec.crianca.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findById(Long id);
    @Query("SELECT c.criancas FROM Cidade c WHERE LOWER(c.nome) LIKE LOWER(concat('%', ?1, '%'))")
    List<Crianca> findByNomeIgnoreCase(String nome);
}