package com.example.rec.cidadeEstado;

import com.example.rec.crianca.ListarCriancasRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<ListarCriancasRequest> listarPorCidade(String nome) {
        var lista = cidadeRepository.findByNomeIgnoreCase(nome);

        try {
            return lista.stream()
                    .map(ListarCriancasRequest::new)
                    .collect(Collectors.toList());
        }catch (NullPointerException ex){
            return null;
        }
    }
}
