package Dominio;

import Dominio.CategoriaProduto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-15T16:38:48")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile ListAttribute<Categoria, CategoriaProduto> categoriasProdutos;
    public static volatile SingularAttribute<Categoria, String> nome;
    public static volatile SingularAttribute<Categoria, Long> id;

}