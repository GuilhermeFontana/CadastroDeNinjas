package dev.java10x.CadastroDeNinjas.MIssoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //missoes
    @GetMapping("/consultarmissoes")
    public List<MissoesModel> todasMissoes(){
        return missoesService.todasMissoes();
    }

    //status da missao
    @GetMapping("/status")
    public String statusMissoes(){
        return "Aqui voce podera ver o status da sua missão atual";
    }


    //cancelar missao
    @DeleteMapping("/cancelamento")
    public String cancelarMissoes(){
        return "Aqui voce podera cancelar sua missao e ser um otario! ";
    }






}
