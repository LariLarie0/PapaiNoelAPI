package com.example.rec.cidadeEstado;

import com.example.rec.crianca.ListarCriancasRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/{nomeCidade}")
    public ResponseEntity<List<ListarCriancasRequest>> ListarPorCidade(@PathVariable("nomeCidade") String nome) {
         var response = cidadeService.listarPorCidade(nome);
         return ResponseEntity.ok().body(response);
    }
}
