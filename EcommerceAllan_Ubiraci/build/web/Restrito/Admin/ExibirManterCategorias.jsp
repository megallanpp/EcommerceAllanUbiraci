<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <title>Categorias</title>

        <script language="JavaScript">
            function setVisibility(id, visibility) {
                document.getElementById(id).style.display = visibility;
            }
        </script>
    </head>
    <body>
        <div class="panel panel-primary" >
            <!-- Default panel contents -->
            <div class="panel-heading">Categorias</div>

            <c:if test="${not empty error}">
                <div class="alert alert-warning" role="alert">${error}</div>
            </c:if>
            <c:if test="${not empty success}">
                <div class="alert alert-success" role="alert">${success}</div>
            </c:if>                

            <!-- List group -->
            <ul class="list-group">
                <c:forEach items="${requestScope.categorias}" var="categoria"> 
                    <li class="list-group-item">     
                        <div class="control-group">
                            <a href="#">${categoria.nome} <span class="badge">${categoria.produtos.size()}</span></a>
                        </div> 
                        <div class="control-group">
                            <div class="controls">
                                <a onclick="setVisibility('divEditar_${categoria.id}', 'inline');"> Editar </a>
                                <a href="${pageContext.request.contextPath}/categoriafc?tipo=excluir&id=${categoria.id}"> Excluir </a>
                            </div>
                            <div class="controls" id="divEditar_${categoria.id}" style="display: none">
                                <form method="POST" action="${pageContext.request.contextPath}/categoriafc?tipo=alterar&id=${categoria.id}">
                                    Nome: <input type="text" name="nome" value="${categoria.nome}">
                                    <button type="submit" class="btn btn-small btn-primary" >Salvar</button>
                                </form>                                
                            </div>
                        </div> 
                    </li>
                </c:forEach>
            </ul>
        </div>   

        <a href="${pageContext.request.contextPath}/ServletInserirCategoria"> Inserir nova categoria </a>

    </body>
</html>