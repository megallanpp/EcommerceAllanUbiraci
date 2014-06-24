<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
    </head>
    <body>

        <div class="formasPagamento">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Finalizando a sua compra!</h3>
                </div>
                <div class="panel-body">

                    <div class="colunaUm">
                        <div class="dadosCompra">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Dados de Compra</h3>
                                </div>
                                <div class="panel-body">
                                    Total em produtos: R$ 55,00 <br/>
                                    Frete para Itajaí: R$ 13,00 <br/>  
                                    TOTAL:             R$ 68,00 <br/><br/>
                                    Total no boleto:   R$ 65,00 <br/>
                                </div>
                            </div>
                        </div>
                        <div class="enderecoEntrega">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Endereço de Entrega</h3>
                                </div>
                                <div class="panel-body">
                                    Destinatário: Bira Junior <br/>
                                    Endereço: Rua Estudante Renato Victorino, 273 - Apto 201 - Dom Bosco - Itajaí<br><br>

                                    <div class="btn-group" style="margin-bottom: 6px;">
                                        <button type="button" class="btn btn-info">Alterar endereço de entrega</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="formaEntrega">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">Método de Envio</h3>
                            </div>
                            <div class="radio" style="margin-left: 15px;">
                                <label>
                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                                    Econômica - Frete grátis | 12 dias úteis
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="pagamento">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">Formas de Pagamento</h3>
                            </div>
                            <ul class="modoPagamento">
                                <li>
                                    <input type="radio" name="cartao" id="cartao" value="opcao1">
                                    <img src="${pageContext.request.contextPath}/resources/cc.jpg" id="ccredit" style=" width:11%" alt="cartao credito"/>
                                </li>
                                <li>
                                    <input type="radio" name="boleto" id="boleto" value="opcao2">
                                    <img src="${pageContext.request.contextPath}/resources/boleto.jpg" id="boleto" style=" width:5%" alt="boleto"/>
                                </li>
                                <li>
                                    <input type="radio" name="loja" id="loja" value="opcao3">
                                    <img src="${pageContext.request.contextPath}/resources/loja.png" id="loja" style=" width:5%" alt="loja"/>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="btnFinalCompra">
            <a href="${pageContext.request.contextPath}/ServletFinalizarCompra" class="btn btn-primary" role="button">
                Finalizar compra
            </a> 
        </div>
    </body>
</html>        