package dev.java10x.CadastroDeNinjas.MIssoes;


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

}
