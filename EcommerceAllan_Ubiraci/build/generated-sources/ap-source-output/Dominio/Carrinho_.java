package Dominio;

import Dominio.Pessoa;
import Dominio.ProdutoCarrinho;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-01T20:40:43")
@StaticMetamodel(Carrinho.class)
public class Carrinho_ { 

    public static volatile SingularAttribute<Carrinho, Pessoa> pessoa;
    public static volatile ListAttribute<Carrinho, ProdutoCarrinho> produtosCarrinhos;
    public static volatile SingularAttribute<Carrinho, Long> id;
    public static volatile SingularAttribute<Carrinho, Date> dataCompra;

}