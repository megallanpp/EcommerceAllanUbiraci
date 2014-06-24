package Dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tab_perfil")
@Entity
public class Perfil implements Serializable {

    private String nomePerfil;
    
    @OneToOne(mappedBy = "perfil")
    private Pessoa pessoa;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Perfil() {
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String newVal) {
        nomePerfil = newVal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
