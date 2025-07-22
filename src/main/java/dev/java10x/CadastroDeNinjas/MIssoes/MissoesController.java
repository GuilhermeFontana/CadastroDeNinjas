package dev.java10x.CadastroDeNinjas.MIssoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;
    private MissoesDTO missoesDTO;

    public MissoesController(MissoesService missoesService, MissoesDTO missoesDTO) {
        this.missoesService = missoesService;
        this.missoesDTO = missoesDTO;
    }

    //adicionar missoes
    @PostMapping("/criarmissao")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missaoadd){
        return missoesService.criarMissao(missaoadd);
    }


    //missoes
    @GetMapping("/vermissoes")
    public List<MissoesDTO> todasMissoes(){
        return missoesService.todasMissoes();
    }

    //consultar por id

    @GetMapping("/consultaPorId/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id){
        return missoesService.consultaMissoesId(id);
    }


    //alterar algo da missao
    @PatchMapping
    public ResponseEntity<String> attMissao (@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        if (missoesService.atualizarMissao(id, missaoAtualizada) != null){
            missoesService.atualizarMissao(id, missaoAtualizada);
            return ResponseEntity.ok("Missao do id: " + id + ". Atualizada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao do Id: " + id + ". Não existe em nosso sistema!");
        }
    }



    //deletar  missao

    @DeleteMapping("/deletarmissao/{id}")
    public void deletarMissao (@PathVariable Long id){
        missoesService.deletarMissao(id);
    }






}
