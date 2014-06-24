package Dominio;

import Dominio.Carrinho;
import Dominio.Produto;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "tab_produtocarrinho")
@Entity
public class ProdutoCarrinho implements Serializable {

    @Temporal(TemporalType.DATE)
    private Date dataInclusao;
    
    private int quantidade;
    private double valorUnitario;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Carrinho carrinho;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Pedido pedido;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ProdutoCarrinho(Produto produto, Carrinho carrinho) {
        this.produto = produto;
        this.carrinho = carrinho;
        this.dataInclusao = new Date();
    }

    public ProdutoCarrinho() {
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setDataInclusao(Date newVal) {
        dataInclusao = newVal;
    }

    public void setValorUnitario(int newVal) {
        valorUnitario = newVal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
