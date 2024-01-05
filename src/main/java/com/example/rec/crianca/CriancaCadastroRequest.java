package com.example.rec.crianca;

import com.example.rec.Status;

public record CriancaCadastroRequest (
    String nome,
    int idade,
    Long cidadeId,
    Status status,
    String presenteSolicitado
){
}
