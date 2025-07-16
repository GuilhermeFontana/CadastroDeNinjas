package dev.java10x.CadastroDeNinjas.MIssoes;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }


    //Missoes Listar
    public List<MissoesModel> todasMissoes(){
        return missoesRepository.findAll();
    }



}
