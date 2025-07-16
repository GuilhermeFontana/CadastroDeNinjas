package dev.java10x.CadastroDeNinjas.MIssoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //add lista

    public MissoesModel criarMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }


    //Missoes Listar
    public List<MissoesModel> todasMissoes(){
        return missoesRepository.findAll();
    }

    //Missoes listar por id

    public MissoesModel consultaMissoesId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
    }


    //Missoes alterar


    //Missoes Delete
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }




}
