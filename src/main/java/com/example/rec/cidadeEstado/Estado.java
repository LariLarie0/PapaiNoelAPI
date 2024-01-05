package com.example.rec.cidadeEstado;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String uf;
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades;

    public Estado(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }
}
