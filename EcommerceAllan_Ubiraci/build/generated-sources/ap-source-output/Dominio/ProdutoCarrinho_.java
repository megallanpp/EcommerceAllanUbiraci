package Dominio;

import Dominio.Carrinho;
import Dominio.Pedido;
import Dominio.Produto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-15T16:38:48")
@StaticMetamodel(ProdutoCarrinho.class)
public class ProdutoCarrinho_ { 

    public static volatile SingularAttribute<ProdutoCarrinho, Produto> produto;
    public static volatile SingularAttribute<ProdutoCarrinho, Pedido> pedido;
    public static volatile SingularAttribute<ProdutoCarrinho, Date> dataInclusao;
    public static volatile SingularAttribute<ProdutoCarrinho, Carrinho> carrinho;
    public static volatile SingularAttribute<ProdutoCarrinho, Long> id;
    public static volatile SingularAttribute<ProdutoCarrinho, Integer> quantidade;
    public static volatile SingularAttribute<ProdutoCarrinho, Double> valorUnitario;

}