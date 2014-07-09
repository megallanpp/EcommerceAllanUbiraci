package Dominio;

import Dominio.CategoriaProduto;
import Dominio.ProdutoCarrinho;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-01T20:40:43")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile ListAttribute<Produto, CategoriaProduto> categoriasProdutos;
    public static volatile ListAttribute<Produto, ProdutoCarrinho> produtosCarrinhos;
    public static volatile SingularAttribute<Produto, Double> valor;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, String> nomeArquivoImagem;
    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile SingularAttribute<Produto, String> descricao;

}