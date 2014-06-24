<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <title>Header</title>
    </head>
    <body>
        <div class="form-head">
            <form method="POST" action="/EcommerceAllan_Ubiraci/ServletProduto">
                <c:choose>
                    <c:when test="${sessionScope.logado}">
                        Você está logado | 
                        <a href="${pageContext.request.contextPath}/logout.jsp">logoff</a>
                        | 
                        <a href="${pageContext.request.contextPath}/ServletManterProdutos">Manter Produtos</a>
                        | 
                        <a href="${pageContext.request.contextPath}/ServletManterCategorias">Manter Categorias</a>
                    </c:when>
                    <c:otherwise>
                        Bem vindo visitante! Faça seu <a href="${pageContext.request.contextPath}/login.jsp">login</a> ou <a href="${pageContext.request.contextPath}/ServletCadastroPessoa">cadastre-se!</a>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
        <div class="searchComponents">
            <div class="carrinho">
                <a href="${pageContext.request.contextPath}/ServletCarrinho">
                    <img src="${pageContext.request.contextPath}/resources/img_carrinho_compra_64x64.png" id="topPanel-search-carrinho" alt="carrinho"/>
                </a>
            </div>
            <div class="searchField">
                <div class="input-group-sm">
                    <input type="text" class="form-control" placeholder="Buscar" id="topPanel-search-input">
                </div>
                <div class="btn-group">
                    <button type="submit" class="btn btn-primary btn-small" id="topPanel-search-button" >
                        <span class="glyphicon glyphicon-search"></span> 
                    </button>
                </div>
            </div>
        </div>
    </body>
</html>