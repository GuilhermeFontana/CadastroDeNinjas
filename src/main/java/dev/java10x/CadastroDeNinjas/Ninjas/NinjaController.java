package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {


    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    //Adicionar ninjas (create)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjass();
        return ResponseEntity.ok(ninjas);
    }

    //Mostra ninjas por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){

         NinjaDTO ninja=ninjaService.listarNinjasPorId(id);
         if (ninjaService.listarNinjasPorId(id) != null) {
             return ResponseEntity.ok(ninja);
         } else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não possuimos o ninja do ID: " + id + " Em nossos registros!");
         }

    }



    //Alterar ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
       if (ninjaService.atualizarNinja(id, ninjaAtualizado ) != null ){
           ninjaService.atualizarNinja(id, ninjaAtualizado);
           return ResponseEntity.ok("Ninja do Id:" + id + " Atualizado com sucesso! ");
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com id: " + id + " não encontrado! ");
       }
    }

    //Deletar Ninjas por id


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjasPorId( @PathVariable  Long id) {
      if (ninjaService.listarNinjasPorId(id) != null){
          ninjaService.deletarNinjasPorId(id);
          return ResponseEntity.ok("Ninja detatado com sucesso: " + id);
      }else {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com id: " + id + " não encontrado! ");
      }

    }







    }
