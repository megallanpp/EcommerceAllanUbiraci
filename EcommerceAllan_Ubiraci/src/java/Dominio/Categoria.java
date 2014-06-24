/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 1886460
 */
@Table(name = "tab_categoria")
@Entity
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 100, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "categoria")
    private List<CategoriaProduto> categoriasProdutos;

    public Categoria() {
        this.categoriasProdutos = new ArrayList<CategoriaProduto>();
    }

    public Categoria(String nome) {
        this.categoriasProdutos = new ArrayList<CategoriaProduto>();
        
        this.nome = nome;
    }

    public void setProdutos(List<Produto> produtos){
        this.categoriasProdutos.clear();
        
        for (Produto produto : produtos) {
            CategoriaProduto cp = new CategoriaProduto(this, produto);
            this.categoriasProdutos.add(cp);
        }              
    }
    
    public List<Produto> getProdutos(){
        List<Produto> listProdutos = new ArrayList<Produto>();
        
        for(CategoriaProduto categoriaProduto : this.categoriasProdutos){
            listProdutos.add(categoriaProduto.getProduto());
        }
        return listProdutos;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
