package com.example.rec.crianca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CriancaRepository extends JpaRepository<Crianca, Long> {
    Optional<Crianca> findById(Long ig);
    List<Crianca> findByBomComportamentoTrue();

    @Query("SELECT c FROM Crianca c JOIN c.cidade ci WHERE ci.nome = :nome")
    List<Crianca> findByCidade(@Param("nome") String nome);
}