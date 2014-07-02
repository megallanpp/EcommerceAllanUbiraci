<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <title>Cadastro</title>
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
                        <form method="post" action="/EcommerceAllan_Ubiraci/index.jsp">
                            <div class="form-group">
                                <label for="username">Nome:</label>
                                <input type="text" class="form-control" name="username" id="username" placeholder="Nome Completo" autofocus="username" required>
                            </div>
                            <div class="form-group">
                                <label for="endereco">Endereço:</label>
                                <input type="text" class="form-control" name="endereco" id="endereco" placeholder="Endereço" required>
                            </div>
                            <div class="form-group">
                                <label for="telefone">Telefone:</label>
                                <input type="text" class="form-control" name="telefone" id="telefone" placeholder="Telefone" required>
                            </div>
                            <div class="form-group">
                                <label for="cpf" >CPF:</label>
                                <input type="text" class="form-control" name="cpf" id="cpf" placeholder="000.000.000-00" required pattern="\d{3}\.\d{3}\.\d{3}-\d{2}">
                            </div>
                            <div class="form-group">
                                <label for="email">E-mail:</label>
                                <input type="email" class="form-control" name="email" id="email" placeholder="email@email.com.br" required>
                            </div>
                            <div class="form-group">
                                <label for="senha">Senha:</label>
                                <input type="password" class="form-control" name="senha" id="senha" placeholder="Senha" required>
                            </div>
                            <div class="form-group">
                                <label for="redsenha">Redigite a Senha:</label>
                                <input type="password" class="form-control" name="redsenha" id="redsenha" placeholder="Confirmação da Senha" required>
                            </div>
                            <div class="form-group">                                
                                <button type="submit" name="enviar" class="btn btn-primary pull-left">Cadastrar</button>
                            </div>
                            <a href="${pageContext.request.contextPath}/"> Cancelar </a>
                        </form>
                </div>
            </div> 
        </div>
        <div class="fotter">
            <jsp:include page="/WEB-INF/pages/footer.jsp"/>
        </div>
    </body>
</html>
