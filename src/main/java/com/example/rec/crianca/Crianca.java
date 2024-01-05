package com.example.rec.crianca;

import com.example.rec.cidadeEstado.Cidade;
import com.example.rec.cidadeEstado.Estado;
import com.example.rec.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Crianca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    private boolean bomComportamento;
    private Status status;
    private String presenteSolicitado;
    private LocalDateTime dataPresente;

    public Crianca(String nome, int idade, Cidade cidade, Estado estado, boolean bomComportamento, Status status, String presenteSolicitado) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
        this.bomComportamento = bomComportamento;
        this.status = status;
        this.presenteSolicitado = presenteSolicitado;
    }

    public boolean isBomComportamento() {
        return bomComportamento;
    }
}