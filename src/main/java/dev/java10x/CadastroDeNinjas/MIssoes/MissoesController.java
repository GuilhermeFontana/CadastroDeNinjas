package dev.java10x.CadastroDeNinjas.MIssoes;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //adicionar missoes
    @PostMapping("/criarmissao")
    public  ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missaoadd){
        missoesService.criarMissao(missaoadd);
        return ResponseEntity.ok("Missao criada Com sucesso! ");
        }


    //missoes
    @GetMapping("/disponiveis")
    public List<MissoesDTO> todasMissoes(){
        return missoesService.todasMissoes();
    }

    //consultar por id

    @GetMapping("/disponiveis/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
        MissoesDTO missao =  missoesService.consultaMissoesId(id);
        if (missoesService.consultaMissoesId(id) != null){
            return ResponseEntity.ok(missao);
        }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao não existente!");
        }
    }



    //alterar algo da missao
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<String> attMissao (@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        if (missoesService.atualizarMissao(id, missaoAtualizada) != null){
            return ResponseEntity.ok("Missao do id: " + id + ". Atualizada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao do Id: " + id + ". Não existe em nosso sistema!");
        }
    }


    //deletar  missao

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao (@PathVariable Long id){

         if (missoesService.consultaMissoesId(id) != null){
             missoesService.deletarMissao(id);
           return   ResponseEntity.ok("Missao do ID: "+ id + ". Deletado com sucesso!");
         }else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Missao nao encontrada!");
         }


    }


}
