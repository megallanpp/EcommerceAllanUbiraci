<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <title>Listar Produtos</title>
    </head>
    <body>

        <div class="panel panel-primary">
            <div class="panel-body">                
                <%-- <h1>Produtos</h1> --%>
                <jsp:include page="/WEB-INF/pages/${param.content}Ordenacao.jsp"/>
            </div>
            <div class="panel-footer">
                <div class="container" style="width: 819px">
                    <div class="row">
                        <c:forEach items="${requestScope.produtos}" var="produto"> 
                            <div class="col-sm-6 col-md-3">
                                <div class="thumbnail">
                                    <img src="${pageContext.request.contextPath}/resources/uploads/${produto.nomeArquivoImagem}" alt="produto">
                                </div>
                                <div class="caption">
                                    <h3>${produto.nome}</h3>
                                    <p>${produto.descricao}</p>
                                    <p>                  
                                        <c:forEach items="${produto.categorias}" var="categoria"> 
                                            ${categoria.nome}
                                        </c:forEach>                                          
                                    </p>
                                    <p>
                                        <a href="#" class="btn btn-primary" role="button">Comprar</a> 
                                    </p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>                   
                </div>
            </div>
        </div>
    </body>
</html>
