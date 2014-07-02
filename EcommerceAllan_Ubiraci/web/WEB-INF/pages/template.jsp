<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>${param.title}</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos.css" />
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
    </head>
    <body style="width: 1263px;">
        
            <div class="topDiv">
                <jsp:include page="/WEB-INF/pages/header.jsp"/>
            </div>

            <div class="middleDiv">

                <div class="leftPanel">
                    <jsp:include page="/WEB-INF/pages/ListarCategorias.jsp"/>
                </div>

                <div class="middlePanel">
                    <span id="middlePanel-content">
                        <jsp:include page="/WEB-INF/pages/${param.content}.jsp"/>
                    </span>
                </div>            
            </div>	
            <div class="fotter">
                <jsp:include page="/WEB-INF/pages/footer.jsp"/>
            </div>
        
    </body>
</html>