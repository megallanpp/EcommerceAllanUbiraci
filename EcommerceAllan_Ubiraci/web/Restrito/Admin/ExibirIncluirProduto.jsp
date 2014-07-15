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
            <form method="POST" action="${pageContext.request.contextPath}/produtofc?tipo=incluir">
                Nome: <input type="text" name="nome" value=""> </br>
                Descricao: <input type="text" name="descricao" value=""> </br>
                Valor: <input type="text" name="valor" value=""> (ex:9.99)</br>

                <button type="submit" class="btn btn-small btn-primary" >Salvar</button>
            </form>

        </div>
    </body>
</html>
