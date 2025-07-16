package dev.java10x.CadastroDeNinjas.Ninjas;


import dev.java10x.CadastroDeNinjas.MIssoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nome_ninja")
    private String nome;


    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    // o ninja tem somente uuma unica missao
    @ManyToOne
    @JoinColumn(name ="missoes_id") // foreing key
    private MissoesModel missoes;


}
