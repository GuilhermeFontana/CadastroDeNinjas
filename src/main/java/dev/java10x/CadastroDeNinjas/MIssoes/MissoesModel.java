package dev.java10x.CadastroDeNinjas.MIssoes;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private RankMissoes dificuldadeMissoes;

    public MissoesModel() {
    }

    public MissoesModel(long id, String nome, RankMissoes dificuldadeMissoes) {
        this.id = id;
        this.nome = nome;
        this.dificuldadeMissoes = dificuldadeMissoes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RankMissoes getDificuldadeMissoes() {
        return dificuldadeMissoes;
    }

    public void setDificuldadeMissoes(RankMissoes dificuldadeMissoes) {
        this.dificuldadeMissoes = dificuldadeMissoes;
    }
}
