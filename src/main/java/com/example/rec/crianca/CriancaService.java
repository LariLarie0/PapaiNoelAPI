package com.example.rec.crianca;

import com.example.rec.cidadeEstado.Cidade;
import com.example.rec.cidadeEstado.CidadeRepository;
import com.example.rec.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriancaService {
    @Autowired
    private CriancaRepository criancaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public Crianca cadastro(CriancaCadastroRequest dados){
        Crianca crianca = new Crianca();

        Cidade cidade = cidadeRepository.getReferenceById(dados.cidadeId());

        if(sortearBoolean()){
            crianca.setBomComportamento(true);
            crianca.setStatus(Status.PENDENTE);
        } else{
            crianca.setBomComportamento(false);
            crianca.setStatus(Status.NEGADO);
        }
        crianca.setNome(dados.nome());
        crianca.setIdade(dados.idade());
        crianca.setPresenteSolicitado(dados.presenteSolicitado());
        crianca.setCidade(cidade);
        crianca.setEstado(cidade.getEstado());

        return crianca;
    }

    public ListarCriancasRequest cadastrarCrianca(CriancaCadastroRequest dados){
        Crianca crianca = cadastro(dados);
        criancaRepository.save(crianca);
        return new ListarCriancasRequest(crianca);
    }

    public List<ListarCriancasRequest> listarCriancas(){
        List<Crianca> crianca = criancaRepository.findAll();
        try {
            return crianca.stream().map((Crianca id) -> new ListarCriancasRequest(id))
                    .collect(Collectors.toList());
        }catch (NullPointerException ex){
            return null;
        }
    }

    public List<ListarCriancasRequest> listarCriancasComBomComportamento(){
        List<Crianca> crianca = criancaRepository.findByBomComportamentoTrue();
        try {
            return crianca.stream()
                    .map(ListarCriancasRequest::new)
                    .collect(Collectors.toList());
        }catch (NullPointerException ex){
            return null;
        }
    }

    public List<ListarCriancasRequest> listarCriancasPorCidade(String cidade){
        List<Crianca> crianca = criancaRepository.findByCidade(cidade);
        try {
            return crianca.stream().map(ListarCriancasRequest::new)
                    .collect(Collectors.toList());
        }catch (NullPointerException ex){
            return null;
        }
    }

    public boolean sortearBoolean(){
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        int numero = (int)(Math.random() * range) + min;

        if(numero % 2 == 0){
            return true;
        } else{
            return false;
        }

    }

    public ListarCriancasRequest entregarPresente(Long criancaId) {
        Crianca crianca = criancaRepository.getReferenceById(criancaId);
        if(crianca.isBomComportamento()){
            if(crianca.getStatus() == Status.ENTREGUE){
                return new ListarCriancasRequest(crianca);
            } else{
                crianca.setStatus(Status.ENTREGUE);
                crianca.setDataPresente(LocalDateTime.now());

                criancaRepository.save(crianca);

                return new ListarCriancasRequest(crianca);
            }
        } else{
            return null;
        }
    }
}