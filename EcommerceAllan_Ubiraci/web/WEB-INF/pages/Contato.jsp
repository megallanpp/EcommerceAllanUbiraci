<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/estilos.css" />
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
        <title>Contato</title>
    </head>
    <body style="width: 1263px;">
        <div class="topDiv">
            <jsp:include page="/WEB-INF/pages/header.jsp"/>
        </div>
        <div id="contacts">
            <div class="row">	
                <div class="col-sm-offset-3 col-sm-6">
                    <form name="sentMessage" class="well" id="contactForm"  novalidate>
                        <legend>Contato</legend>
                        <div class="control-group">
                            <div class="controls">
                                <input type="text" class="form-control" 
                                       placeholder="Nome Completo" id="name" required
                                       data-validation-required-message="Por favor, nos informe o seu nome" />
                            </div>
                        </div> 	
                        <div class="control-group">
                            <div class="controls">
                                <input type="email" class="form-control" placeholder="E-mail" 
                                       id="email" required
                                       data-validation-required-message="Por favor informe o seu e-mail" />
                            </div>
                        </div> 	

                        <div class="control-group">
                            <div class="controls">
                                <textarea rows="10" cols="100" class="form-control" placeholder="Mensagem" id="message" required data-validation-required-message="Por favor, digite a sua mensagem" minlength="5" data-validation-minlength-message="Min 5 characters" maxlength="999" style="resize:none">
                                </textarea>
                            </div>
                        </div> 
                        <br>
                        <button type="submit" class="btn btn-primary pull-right">
                            Enviar
                        </button><br>
                    </form>
                </div>
            </div>
        </div>
        <div class="fotter">
            <jsp:include page="/WEB-INF/pages/footer.jsp"/>
        </div>
    </body>
</html>
