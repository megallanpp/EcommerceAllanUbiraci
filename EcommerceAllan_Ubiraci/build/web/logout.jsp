<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <script type="text/javascript">
        <!--
     var numero = 5;
        function chamar() {
            if (numero > 0) {
                document.getElementById('timers').innerHTML = --numero;
            }
        }
        setInterval("chamar();", 1000);
        setTimeout("document.location = '/EcommerceAllan_Ubiraci/ServletProduto';", 10000);
        //-->
    </script> 
    <body>

        <%
            session.invalidate();
            //response.sendRedirect("startpage.html");
        %>
        Encerrando a sessão.
        <div align="center" style="font-family: tahoma; font-size: 16px;">
            Você será redirecionado em: <br><div style="font-family: tahoma; font-size: 56px;" id="timers">5</div>
        </div>        
    </body>
</html>
