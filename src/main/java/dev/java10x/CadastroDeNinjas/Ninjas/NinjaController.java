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

    @GetMapping("/boasvindas")
        public String boasVindas(){
            return "Essa é minha primeira mensagem nessa rota";
        }


    //Adicionar ninjas (create)
    @PostMapping("/adicionar")
    public String adicionarNinja(){
            return "Ninja criado";
    }

    //mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjass();
    }

    //Mostra ninjas por id (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
            return "Ninjas por id";
    }
    //Alterar ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjasPorId() {
        return "Alterar ninjas por id";
    }

    //Deletar Ninjas por id
    @DeleteMapping("/deletarID")
    public String deletarNinjasPorId() {
        return "deletar ninjas por id";
    }



    }
