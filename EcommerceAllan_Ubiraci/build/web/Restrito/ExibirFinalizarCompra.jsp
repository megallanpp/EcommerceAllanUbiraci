<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="resources/estilos.css" type="text/css"/>
    </head>
    <body>
        <div class="compraFinalizada">
            <h1>Sua compra foi efetuada com sucesso!</h1><br>
            <p>Em breve você receberá um e-mail com os dados de sua compra.</p><br>
            <img src="${pageContext.request.contextPath}/resources/compraFinalizada.png" id="compraFinal" style=" width:5%" alt="compraFinal"/>
        </div>
        <%--<a href="${pageContext.request.contextPath}/ServletAcompanharCompras">
                Acompanhe seu pedido.
            </a>        
        --%>
    </body>
</html>        