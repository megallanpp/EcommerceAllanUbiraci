<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="css/bootstrap-3.1.1-dist/css/bootstrap.css" type="text/css"/>
    </head>
    <body>


        <div style="float: right">
            <label>Categorias:</label>
            <select id = "myList">
                <option value = "1">one</option>
                <option value = "2">two</option>
                <option value = "3">three</option>
                <option value = "4">four</option>
            </select>
        </div>

        <div>
            <b>Classificar:</b>
            <select name="ddlFuncao">
                <option value="valor">Valor</option>
                <option value="maisVendidos">Mais vendidos</option>
            </select>   
        </div>      

        <div id="divResultadosPorPagina">            
            <div style="float: left ; width: 450px;">
                Resultado(s) 1 - 20 de 2161 | Itens por Página: 

                <select name="ddlItensPorPagina">
                    <option value="20">20</option>
                    <option value="40">40</option>
                </select>             
            </div>      
            <div style="float: right ; width: 260px;">
                < Páginas: 
                <a href="#">1</a> 
                <a href="#">2</a> 
                <a href="#">3</a> 
                <a href="#">4</a> 
                <a href="#">5</a> 
                <a href="#">6</a> 
                <a href="#">7</a> 
                <a href="#">8</a> 
                <a href="#">9</a> 
                <a href="#">10</a> 
                ... >
            </div>      
        </div>      

        <a href="${pageContext.request.contextPath}" style="display: none">
            <img src="${pageContext.request.contextPath}/resources/img_ordencao_paginacao.png" style="width: 850px" alt="paginacao"/>
        </a>

    </body>
</html>