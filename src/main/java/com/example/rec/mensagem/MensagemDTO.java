package com.example.rec.mensagem;

public record MensagemDTO(
    String mensagem
){

    public MensagemDTO(MensagemResponse mensagem){
        this(mensagem.mensagem());
    }
}
