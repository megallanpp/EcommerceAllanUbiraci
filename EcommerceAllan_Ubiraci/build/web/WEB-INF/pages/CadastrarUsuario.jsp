<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
    </head>
    <body>
        <form method="link" action="/EcommerceAllan_Ubiraci/index.jsp">
            <div>
                <h1>Cadastre-se:</h1>
                <p>Seja bem vindo Visitante. Cadastre-se no nosso site e veja nossas promoções!</p>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">Nome:</label>
                    <div class="controls">
                        <input type="text" id="inputName" placeholder="Nome" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">Endereço:</label>
                    <div class="controls">
                        <input type="text" id="inputAdress" placeholder="Endereço" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">Telefone:</label>
                    <div class="controls">
                        <input type="text" id="inputPhoneNumber" placeholder="Telefone" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">CPF: (xxx.xxx.xxx-xx)</label>
                    <div class="controls">
                        <input type="text" id="inputCPF" placeholder="CPF" required pattern="\d{3}\.\d{3}\.\d{3}-\d{2}">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">Login:</label>
                    <div class="controls">
                        <input type="text" id="inputLogin" placeholder="Login" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">Senha:</label>
                    <div class="controls">
                        <input type="password" id="inputPassword" placeholder="Senha" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">Lembrar Senha:</label>
                    <div class="controls">
                        <input type="password" id="inputPasswordLembrar" placeholder="Senha novamente" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputEmail">E-mail:</label>
                    <div class="controls">
                        <input type="text" id="inputEmail" placeholder="E-mail" required pattern="([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})">
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <br>
                        <button type="submit" class="btn btn-small btn-primary">Cadastar</button>
                        <a href="${pageContext.request.contextPath}/"> Cancelar </a>
                    </div>
                </div> 
            </div>
        </form>
    </body>
</html>
