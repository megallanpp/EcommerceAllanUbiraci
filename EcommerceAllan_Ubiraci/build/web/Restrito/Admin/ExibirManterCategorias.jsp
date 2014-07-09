<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <title>Categorias</title>
    </head>
    <body>
        <div class="panel panel-primary" >
            <!-- Default panel contents -->
            <div class="panel-heading">Categorias</div>
            <!-- List group -->
            <ul class="list-group">
                <c:forEach items="${requestScope.categorias}" var="categoria"> 
                    <li class="list-group-item">     
                        <a href="#">${categoria.nome} <span class="badge">${categoria.produtos.size()}</span></a>
                        <br>
                        <input type="text" value="${categoria.nome}">
                        <div class="control-group">
                            <div class="controls">
                                <br>
                                <button type="submit" class="btn btn-small btn-primary" >Salvar</button>
                                <a href="${pageContext.request.contextPath}/"> Excluir </a>
                            </div>
                        </div> 
                    </li>
                </c:forEach>
            </ul>
        </div>        
    </body>
</html>