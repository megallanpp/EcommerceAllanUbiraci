<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Categorias</title>
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
    </head>
    <body>
        <c:if test="${not empty error}">
            <div class="alert alert-warning" role="alert">${error}</div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="alert alert-success" role="alert">${success}</div>
        </c:if>            
        <div class="panel panel-primary" >
            <!-- Default panel contents -->
            <div class="panel-heading">Categorias</div>
            <div class="panel-body">
                <p>Veja a lista de categoria com a quantidade de produtos.</p>
            </div>
            <!-- List group -->
            <ul class="list-group">
                <c:forEach items="${requestScope.categorias}" var="categoria"> 
                    <li class="list-group-item">          
                        <a href="#">${categoria.nome} <span class="badge">${categoria.produtos.size()}</span></a>
                    </li>
                </c:forEach>
            </ul>
        </div>        
    </body>
</html>