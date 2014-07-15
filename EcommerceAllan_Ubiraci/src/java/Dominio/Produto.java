package Dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tab_produto")
@Entity
public class Produto implements Serializable, Comparable<Produto> {

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<CategoriaProduto> categoriasProdutos;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoCarrinho> produtosCarrinhos;

    @Column(length = 100)
    private String descricao;

    @Column(length = 100, nullable = false)
    private String nome;

    private double valor;

    @Column(length = 255)
    private String nomeArquivoImagem;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Produto() {
        this.categoriasProdutos = new ArrayList<CategoriaProduto>();
        this.produtosCarrinhos = new ArrayList<ProdutoCarrinho>();
    }

    public Produto(String nome, String descricao, double valor, List<Categoria> categorias, String nomeArquivoImagem) {
        this.categoriasProdutos = new ArrayList<CategoriaProduto>();
        this.produtosCarrinhos = new ArrayList<ProdutoCarrinho>();

        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        for (Categoria categoria : categorias) {
            CategoriaProduto cp = new CategoriaProduto(categoria, this);
            this.categoriasProdutos.add(cp);
        }
        this.nomeArquivoImagem = nomeArquivoImagem;
    }

    public List<Categoria> getCategorias() {
        List<Categoria> listCategorias = new ArrayList<Categoria>();

        for (CategoriaProduto categoriaProduto : this.getCategoriasProdutos()) {
            listCategorias.add(categoriaProduto.getCategoria());
        }
        return listCategorias;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setDescricao(String newVal) {
        descricao = newVal;
    }

    public void setNome(String newVal) {
        nome = newVal;
    }

    public void setValor(double newVal) {
        valor = newVal;
    }

    public String getNomeArquivoImagem() {
        return nomeArquivoImagem;
    }

    public void setNomeArquivoImagem(String nomeArquivoImagem) {
        this.nomeArquivoImagem = nomeArquivoImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean contemCategoria(Categoria categoria) {
        for (Categoria cat : getCategorias()) {
            if(categoria.getId() == cat.getId())
                return true;
        }
        
        return false;
    }

    /**
     * @return the categoriasProdutos
     */
    public List<CategoriaProduto> getCategoriasProdutos() {
        return categoriasProdutos;
    }

    /**
     * @param categoriasProdutos the categoriasProdutos to set
     */
    public void setCategoriasProdutos(List<CategoriaProduto> categoriasProdutos) {
        this.categoriasProdutos = categoriasProdutos;
    }

    /**
     * @return the produtosCarrinhos
     */
    public List<ProdutoCarrinho> getProdutosCarrinhos() {
        return produtosCarrinhos;
    }

    /**
     * @param produtosCarrinhos the produtosCarrinhos to set
     */
    public void setProdutosCarrinhos(List<ProdutoCarrinho> produtosCarrinhos) {
        this.produtosCarrinhos = produtosCarrinhos;
    }
    
    @Override
    public int compareTo(Produto other) {
        return nome.compareTo(other.nome);
    }

}
