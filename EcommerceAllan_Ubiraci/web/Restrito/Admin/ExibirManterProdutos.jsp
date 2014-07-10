<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <title>Produtos</title>
    </head>
    <body>
        <div class="panel panel-primary" >
            <div class="panel-heading">Categorias</div>
            <div class="container">
                <c:forEach items="${requestScope.produtos}" var="produto">   
                    <div class="row">   
                        <div class="col-sm-6 col-md-3" style="width: 1145px; height: 150px;">
                            <div class="thumbnail" style="height: 150px;">
                                <div style="width: 221px; float: left">
                                    <input type="text" value="${produto.nome}">
                                </div>
                                <div style="width: 221px; float: left">
                                    <img src="${pageContext.request.contextPath}/resources/${produto.nomeArquivoImagem}" alt="Generic placeholder thumbnail" style="width: 140px;">
                                </div>
                                <div style="width: 221px; float: left">
                                    <input type="text" value="${produto.descricao}">
                                </div>
                                <div style="width: 221px; float: left ; overflow-y: scroll;">  
                                    <c:forEach items="${produto.categorias}" var="categoria"> 
                                        ${categoria.nome}
                                        <a href="${pageContext.request.contextPath}/"> Excluir </a> 
                                        <br>
                                    </c:forEach>   
                                </div>
                                <div style="width: 221px; float: left">
                                    <button type="submit" class="btn btn-small btn-primary" >Salvar</button>
                                    <a href="${pageContext.request.contextPath}/"> Excluir </a>
                                </div>
                            </div>
                        </div>
                    </div>        
                </c:forEach>                            
            </div>        
        </div>
    </body>
</html>