<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos.css" />
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
    </head>
    <body style="width: 1263px;">
        <div class="topDiv">
            <jsp:include page="/WEB-INF/pages/header.jsp"/>
        </div>
        <div class="container" style="width: 500px;">
            <div class="panel-default">
                <div class="panel-body">
                    <fieldset>
                        <legend>Dados Pessoais</legend>
                        <form method="POST" action="/EcommerceAllan_Ubiraci/ServletAutenticacao">
                            <div class="form-group">

                                <label for="username">Nome:</label>
                                <input type="text" class="form-control" name="username" id="username" autofocus="username">

                            </div>
                            <div class="form-group">
                                <label for="password">Senha:</label>
                                <input type="password" class="form-control" name="password" id="password">
                            </div>        

                            <div class="form-group">                                
                                <button type="submit" name="enviar" class="btn btn-success pull-right">Enviar</button>
                            </div>
                        </form>    
                    </fieldset>
                </div>
            </div>
        </div>
        <div class="fotter">
            <jsp:include page="/WEB-INF/pages/footer.jsp"/>
        </div>
    </body>
</html>