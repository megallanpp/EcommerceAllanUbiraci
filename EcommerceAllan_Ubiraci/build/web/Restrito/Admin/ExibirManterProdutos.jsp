<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <title>Produtos</title>

        <script language="JavaScript">
            function setVisibility(id, visibility) {
                document.getElementById(id).style.display = visibility;
            }
        </script>
    </head>
    <body>
        <div class="panel panel-primary" >
            <div class="panel-heading">Produtos</div>

            <c:if test="${not empty error}">
                <div class="alert alert-warning" role="alert">${error}</div>
            </c:if>
            <c:if test="${not empty success}">
                <div class="alert alert-success" role="alert">${success}</div>
            </c:if>                

            <div class="container">
                <c:forEach items="${requestScope.produtos}" var="produto">   
                    <div class="row">   
                        <div class="col-sm-6 col-md-3" style="width: 1145px;">
                            <div class="thumbnail" id="thumbnail" style="height: 150px;">
                                <div style="width: 221px; height: 150px; float: left">
                                    ${produto.nome}
                                    </br>
                                    ${produto.descricao}
                                </div>
                                <div style="width: 221px; height: 150px; float: left">
                                    <img src="${pageContext.request.contextPath}/resources/${produto.nomeArquivoImagem}" alt="Generic placeholder thumbnail" style="width: 140px;">
                                </div>
                                <div style="width: 221px; height: 150px; float: left ; overflow-y: scroll;">  
                                    <c:forEach items="${produto.categorias}" var="categoria"> 
                                        ${categoria.nome}
                                        <a href="${pageContext.request.contextPath}/categoriaprodutofc?tipo=excluircomids&idproduto=${produto.id}&idcategoria=${categoria.id}"> Excluir </a>
                                        <br>
                                    </c:forEach>  

                                    <c:if test="${empty produto.categorias}">
                                        <div class="alert alert-warning" role="alert">sem categorias associadas</div>
                                    </c:if>
                                </div>
                                <div style="width: 50px; height: 150px; float: left">
                                    <a onclick="
                                            setVisibility('divEditar_${produto.id}', 'inline');
                                            setVisibility('divEditarImagem_${produto.id}', 'none');
                                            setVisibility('divEditarCategoriaProduto_${produto.id}', 'none');"> Editar </a>
                                    <a href="${pageContext.request.contextPath}/produtofc?tipo=excluir&id=${produto.id}"> Excluir </a>
                                </div>


                                <div class="controls" id="divEditar_${produto.id}" style="display: none;">
                                    <form method="POST" action="${pageContext.request.contextPath}/produtofc?tipo=alterar&id=${produto.id}">
                                        Nome: <input type="text" name="nome" value="${produto.nome}"> </br>
                                        Descricao: <input type="text" name="descricao" value="${produto.descricao}"> </br>
                                        Valor: <input type="text" name="valor" value="${produto.valor}"> (ex:9.99) </br>

                                        <button type="submit" class="btn btn-small btn-primary" >Salvar</button>                                    
                                    </form>         
                                    <a onclick="
                                            setVisibility('divEditar_${produto.id}', 'none');
                                            setVisibility('divEditarImagem_${produto.id}', 'inline');
                                            setVisibility('divEditarCategoriaProduto_${produto.id}', 'none');"> Selecionar Imagem </a>
                                    <a onclick="
                                            setVisibility('divEditar_${produto.id}', 'none');
                                            setVisibility('divEditarImagem_${produto.id}', 'none');
                                            setVisibility('divEditarCategoriaProduto_${produto.id}', 'inline');"> Selecionar Categorias </a>                       
                                </div>

                                <div class="controls" id="divEditarImagem_${produto.id}" style="display: none;">
                                    <form method="POST" action="${pageContext.request.contextPath}/produtofc?tipo=alterarimagem&id=${produto.id}}">
                                        Selecione uma nova imagem:

                                        <button type="submit" class="btn btn-small btn-primary" >Salvar</button>                                    
                                    </form>                                
                                </div>

                                <div class="controls" id="divEditarCategoriaProduto_${produto.id}" style="display: none;">
                                    <c:forEach items="${requestScope.categorias}" var="categoria">

                                        <c:if test="${!produto.contemCategoria(categoria)}">
                                            <li >                                                   
                                                <form method="POST" action="${pageContext.request.contextPath}/produtofc?tipo=alterar&id=${produto.id}">
                                                    <div class="control-group">
                                                        ${categoria.nome}
                                                        <input type="hidden" name="idcategoria" value="${categoria.id}" />

                                                        <button type="submit" class="btn btn-small btn-primary" >Relacionar categoria</button>  
                                                    </div> 
                                                </form>   
                                            </li>    
                                        </c:if>

                                    </c:forEach>                             
                                </div>  

                            </div>

                        </div>
                    </div>            
                </c:forEach>                        
            </div>        
        </div>

        <a href="${pageContext.request.contextPath}/ServletInserirProduto"> Inserir novo produto </a>

    </body>
</html>