<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
    </head>
    <body>

        <div class="panel panel-primary">
            <div class="panel-body">
                <%--<h1>Produtos</h1>--%>
            </div>
            <div class="panel-footer">

                <div style="float: left">
                    Carrinho: ${requestScope.carrinho.id}
                </div>

                <div style="float: right">
                    Início compra em: ${requestScope.carrinhodataCompra} xx/xx/xxxx xx:xx:xx
                </div>

                <div class="container">
                    <c:forEach items="${requestScope.carrinho.produtos}" var="produto">   
                        <div class="row">   
                            <div class="col-sm-6 col-md-3" style="width: 1145px; height: 150px;">
                                <div class="thumbnail" style="height: 150px;">
                                    <div style="width: 221px; float: left">
                                        ${produto.nome}
                                    </div>
                                    <div style="width: 221px; float: left">
                                        <img src="http://www.iconsdb.com/icons/download/black/mickey-mouse-22-128.png" alt="prouto">
                                    </div>
                                    <div style="width: 221px; float: left">
                                        Quantidade: <input  type="text" style="width: 50px;"/>
                                    </div>
                                    <div style="width: 221px; float: left">
                                        Valor: R$ 400,00
                                    </div>
                                    <div style="width: 221px; float: left">
                                        <input  type="button" value="Remover do carrinho"/>
                                    </div>
                                </div>
                            </div>
                        </div>               
                    </c:forEach>    
                    <div style="float: left">
                        CEP: <input  type="text"/>
                        Valor Frete: R$ 100,00
                    </div>
                    <div style="float: right">
                        <a href="${pageContext.request.contextPath}/ServletProdutoCarrinho" class="btn btn-primary" role="button">
                            Formas de pagamento
                        </a> 

                        <a href="${pageContext.request.contextPath}/ServletProduto" class="btn btn-primary" role="button">
                            Continuar comprando
                        </a> 
                    </div>
                    <div style="float: right ; width: 175px;">
                        Total: R$ 900,00
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>