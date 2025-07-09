package dev.java10x.CadastroDeNinjas.MIssoes;


import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.NameAlreadyBoundException;


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

    private RankMissoes dificuldadeMissoes;

    //Uma missao pode ter varios ninjas

    @ManyToMany(mappedBy = "missoes")
    private NinjaModel ninjas;



}
