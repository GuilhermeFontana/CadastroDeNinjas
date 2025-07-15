package dev.java10x.CadastroDeNinjas.MIssoes;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissoesController {

    @GetMapping("/bemvindomissoes")
    public String bemVindoMissoes(){
        return "Bem vindo a pagina de missoes!";
    }



    //missoes
    @GetMapping("/missoes")
    public String todasMissoes(){
        return "Aqui voce podera ver as missoes e seus detalhes disponiveis!";
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
