package Dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "tab_carrinho")
@Entity
public class Carrinho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "carrinho")
    private List<ProdutoCarrinho> produtosCarrinhos;
    
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    
    @OneToOne(mappedBy = "carrinho")
    private Pessoa pessoa;

    public Carrinho(List<Produto> produtos) {        
        this.produtosCarrinhos = new ArrayList<ProdutoCarrinho>();
        
        for (Produto produto : produtos) {
            ProdutoCarrinho pc = new ProdutoCarrinho(produto, this);
            this.produtosCarrinhos.add(pc);
        }                     
    }

    public Carrinho() {
        this.produtosCarrinhos = new ArrayList<ProdutoCarrinho>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getDataFormatada() {

        int mes = Integer.parseInt((new SimpleDateFormat("MM")).format(getDataCompra())); //Formato MM-yyyy 
        int ano = Integer.parseInt((new SimpleDateFormat("yyyy")).format(getDataCompra()));
        return mes + "/" + ano;
    }
}
