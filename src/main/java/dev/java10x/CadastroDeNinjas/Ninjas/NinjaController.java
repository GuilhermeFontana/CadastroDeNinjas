package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
            return ninjaService.criarNinja(ninja);
    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjass();
    }

    //Mostra ninjas por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }


    //Alterar ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjasPorId() {
        return "Alterar ninjas por id";
    }

    //Deletar Ninjas por id
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjasPorId( @PathVariable  Long id) {
        ninjaService.deletarNinjasPorId(id);
    }



    }
