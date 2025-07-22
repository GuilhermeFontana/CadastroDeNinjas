package dev.java10x.CadastroDeNinjas.MIssoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }



    //Missoes Listar (Read)
    public List<MissoesDTO> todasMissoes(){
       List<MissoesModel> ninjaModelList = missoesRepository.findAll();
       return ninjaModelList.stream()
               .map(missoesMapper::map)
               .collect(Collectors.toList());
    }




    //add lista (Creat)

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);

    }




    //Missoes listar por id (read)

    public MissoesDTO consultaMissoesId(Long id){
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
         return missaoPorId.map(missoesMapper ::map)
                 .orElse(null);
    }




    //Missoes alterar (Update)

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);

        if (missaoExistente.isPresent()) {
            MissoesModel missaoParaAtualizar = missaoExistente.get();

            // Atualiza APENAS os campos que não são nulos no DTO
            if (missoesDTO.getNome() != null) {
                missaoParaAtualizar.setNome(missoesDTO.getNome());
            }
            if (missoesDTO.getDificuldade() != null) {
                missaoParaAtualizar.setDificuldade(missoesDTO.getDificuldade());
            }
            if (missoesDTO.getNinjas() != null) {
                missaoParaAtualizar.setNinjas(missoesDTO.getNinjas());
            }

            MissoesModel missaoAtualizada = missoesRepository.save(missaoParaAtualizar);
            return missoesMapper.map(missaoAtualizada);
        }
        return null;
    }



    //Missoes Delete (Delete)
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }




}
