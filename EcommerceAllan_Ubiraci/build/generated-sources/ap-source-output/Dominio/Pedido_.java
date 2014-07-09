package Dominio;

import Dominio.ProdutoCarrinho;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-01T20:40:43")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> dataSolicitacao;
    public static volatile ListAttribute<Pedido, ProdutoCarrinho> produtosNoCarrinho;
    public static volatile SingularAttribute<Pedido, Date> dataInclusao;
    public static volatile SingularAttribute<Pedido, Long> id;

}