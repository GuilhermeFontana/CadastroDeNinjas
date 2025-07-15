package dev.java10x.CadastroDeNinjas.MIssoes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.NameAlreadyBoundException;
import java.util.List;


@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String nome;

    private String dificuldade;

    //Uma missao pode ter varios ninjas

    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List <NinjaModel> ninjas;



}
