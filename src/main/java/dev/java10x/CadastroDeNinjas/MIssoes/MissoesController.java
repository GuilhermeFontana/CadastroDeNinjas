package dev.java10x.CadastroDeNinjas.MIssoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
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
    public MissoesModel criarMissao(@RequestBody MissoesModel missaoadd){
        return missoesService.criarMissao(missaoadd);
    }


    //missoes
    @GetMapping("/vermissoes")
    public List<MissoesModel> todasMissoes(){
        return missoesService.todasMissoes();
    }

    //consultar por id

    @GetMapping("/consultaPorId/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.consultaMissoesId(id);
    }


    //alterar algo da missao


    //deletar  missao

    @DeleteMapping("/deletarmissao/{id}")
    public void deletarMissao (@PathVariable Long id){
        missoesService.deletarMissao(id);
    }






}
