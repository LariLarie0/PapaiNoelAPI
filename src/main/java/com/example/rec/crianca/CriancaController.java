package com.example.rec.crianca;

import com.example.rec.mensagem.MensagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criancas")
public class CriancaController {

    @Autowired
    private CriancaService service;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<ListarCriancasRequest> cadastrarCrianca(@RequestBody CriancaCadastroRequest dados){
        if(dados.idade() <= 14){
            var response = service.cadastrarCrianca(dados);
            return ResponseEntity.status(200).body(response);
        } else{
            return ResponseEntity.status(406).build();
        }

    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListarCriancasRequest>> listarCriancas(){
        var response = service.listarCriancas();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/listar/bomComportamento")
    public List<ListarCriancasRequest> listarCriancasComBomComportamento(){
        var response = service.listarCriancasComBomComportamento();
        return response;
    }

    @GetMapping("/listar/{cidade}")
    public List<ListarCriancasRequest> listarCrancasPorCidade(@PathVariable String cidade) {
        var response = service.listarCriancasPorCidade(cidade);
        return response;
    }

    @PostMapping("/entrega/{idCrianca}")
    public ResponseEntity<ListarCriancasRequest> entregarPresente(@PathVariable("idCrianca") Long criancaId) {
        var response = service.entregarPresente(criancaId);
        if(response == null){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.ok(response);
    }
}