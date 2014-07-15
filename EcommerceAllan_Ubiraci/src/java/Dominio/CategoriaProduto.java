/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allan
 */
@NamedQueries(
        {
            @NamedQuery(name = "categoriaproduto.busca",query = "SELECT a from CategoriaProduto a where a.categoria = :categoria and a.produto = :produto")
        }
)
@Table(name = "tab_categoriaproduto")
@Entity
public class CategoriaProduto implements Serializable {

    @Temporal(TemporalType.DATE)
    private Date dataInclusao;

    @ManyToOne//(cascade = CascadeType.ALL)
    private Categoria categoria;

    @ManyToOne//(cascade = CascadeType.ALL)
    private Produto produto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public CategoriaProduto(Categoria categoria, Produto produto) {
        this.categoria = categoria;
        this.produto = produto;
    }

    public CategoriaProduto() {
    }

    /**
     * @return the dataInclusao
     */
    public Date getDataInclusao() {
        return dataInclusao;
    }

    /**
     * @param dataInclusao the dataInclusao to set
     */
    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
