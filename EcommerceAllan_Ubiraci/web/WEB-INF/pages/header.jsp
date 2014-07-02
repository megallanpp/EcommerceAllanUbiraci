<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos.css" />
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
    </head>
    <body style="width: 1263px;">
        <div class="logo">
            <a href="${pageContext.request.contextPath}">
                <img src="${pageContext.request.contextPath}/resources/img_logo_azul.png" alt="logo" width="200px" height="90px"/>
            </a>
        </div>
        <div class="search">
            <div class="topPanel">
                <div class="search">
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
                <div class="departmentTitle">
                    <nav>
                        <ul class="list-inline">
                            <li>
                                <a href="#">
                                    Frete grátis
                                    <b>Confira as regras</b>
                                </a>
                            </li>
                            <li>
                                <%--<a href="#">
                                    até 12% de desconto
                                    <b>No boleto, Confira as regras</b>  
        </a>--%>
                            </li>
                            <li>
                                <a href="#">Em até 15x sem juros
                                    <b>Só com o cartão AUAU</b>
                                </a>
                            </li>
                        </ul>
                    </nav> 
                </div>
            </div>    
        </div>
    </body>
</html>