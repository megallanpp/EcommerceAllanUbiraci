<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Carrinho</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/resources/estilos.css" />
    </head>
    <body>

        <div class="topDiv">
            <jsp:include page="/WEB-INF/pages/header.jsp"/>
        </div>

        <div class="middleDiv">

            <div class="middlePanelCarrinho">

                <%--<jsp:include page="/WEB-INF/pages/${param.content}Ordenacao.jsp"/> --%>

                <span id="middlePanel-content">
                    <jsp:include page="/Restrito/${param.content}.jsp"/>
                </span>
            </div>            
        </div>	

        <div class="fotter">
            <jsp:include page="/WEB-INF/pages/footer.jsp"/>
        </div>
    </body>
</html>