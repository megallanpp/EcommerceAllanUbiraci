package Dominio;

import Dominio.Categoria;
import Dominio.Produto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-15T16:38:48")
@StaticMetamodel(CategoriaProduto.class)
public class CategoriaProduto_ { 

    public static volatile SingularAttribute<CategoriaProduto, Produto> produto;
    public static volatile SingularAttribute<CategoriaProduto, Categoria> categoria;
    public static volatile SingularAttribute<CategoriaProduto, Date> dataInclusao;
    public static volatile SingularAttribute<CategoriaProduto, Long> id;

}