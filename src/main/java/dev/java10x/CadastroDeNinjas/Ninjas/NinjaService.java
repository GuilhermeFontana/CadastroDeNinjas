package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    // Listar todos os ninjas

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }



    // listar ninjas
    public List<NinjaDTO> listarNinjass(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar ninjas por ID

    public NinjaDTO listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }


    //criar ninjas

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //deletarNinjasPorId
    public void deletarNinjasPorId(Long id){
        ninjaRepository.deleteById(id);
    }



    // att ninja
   public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){

       Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
       if (ninjaExistente.isPresent()){
       NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
       ninjaAtualizado.setId(id);
       NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
       return ninjaMapper.map(ninjaSalvo);
       }
    return null;
    }




}
