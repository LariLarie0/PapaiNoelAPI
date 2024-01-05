package com.example.rec.cidadeEstado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salvar-cidade")
public class TesteCidade {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @GetMapping
    public String SalvarCidade() {
        Estado e1 = new Estado("Rio Grande do Sul", "RS");
        Estado e2 = new Estado("Santa Catarina", "SC");
        Estado e3 = new Estado("Paraná", "PR");
        Estado e4 = new Estado("São Paulo", "SP");
        Estado e5 = new Estado("Mato Grosso do Sul", "MS");


        estadoRepository.save(e1);
        estadoRepository.save(e2);
        estadoRepository.save(e3);
        estadoRepository.save(e4);
        estadoRepository.save(e5);

        Cidade c1 = new Cidade("Sapucaia do Sul", e1);
        Cidade c2 = new Cidade("São Leopoldo", e1);
        Cidade c3 = new Cidade("Esteio", e1);
        Cidade c4 = new Cidade("Imbituba", e2);
        Cidade c5 = new Cidade("Jaraguá do Sul", e2);
        Cidade c6 = new Cidade("Balneario Camburiu", e2);

        cidadeRepository.save(c1);
        cidadeRepository.save(c2);
        cidadeRepository.save(c3);
        cidadeRepository.save(c4);
        cidadeRepository.save(c5);
        cidadeRepository.save(c6);

        return "Cidades salvas!";
    }
}
