package com.example.rec.crianca;

import com.example.rec.Status;

import java.time.LocalDateTime;

public record ListarCriancasRequest (
        Long id,
        String nome,
        int idade,
        String cidade,
        String estado,
        boolean bomComportamento,
        Status status,
        String presenteSolicitado,
        LocalDateTime dataEntrega){
    public ListarCriancasRequest(Crianca crianca) {
    this(crianca.getId(), crianca.getNome(), crianca.getIdade(), crianca.getCidade().getNome(),
            crianca.getCidade().getEstado().getNome(), crianca.isBomComportamento(),
            crianca.getStatus(), crianca.getPresenteSolicitado(), crianca.getDataPresente());
    }
}
