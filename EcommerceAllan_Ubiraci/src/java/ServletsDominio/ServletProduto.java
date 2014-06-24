/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsDominio;

import Dominio.Categoria;
import Dominio.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1886460
 */
@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Categoria> categoriaProduto = new ArrayList<Categoria>();
        categoriaProduto.add(new Categoria("Categoria 1"));
        categoriaProduto.add(new Categoria("Categoria 2"));
        categoriaProduto.add(new Categoria("Categoria 3"));
        categoriaProduto.add(new Categoria("Categoria 4"));
        categoriaProduto.add(new Categoria("Categoria 5"));
        categoriaProduto.add(new Categoria("Categoria 6"));
        categoriaProduto.add(new Categoria("Categoria 7"));
        categoriaProduto.add(new Categoria("Categoria 8"));
        categoriaProduto.add(new Categoria("Categoria 9"));
        Categoria categoria10 = new Categoria("Categoria 10");
        List<Produto> produtosCategoria10 = new ArrayList<Produto>();
        produtosCategoria10.add(new Produto("Produto 1", "Descricao produto 1", 9.99, categoriaProduto, "img_produto_xbox_one.jpg"));
        produtosCategoria10.add(new Produto("Produto 2", "Descricao produto 2", 9.99, categoriaProduto, "img_produto_controle_xbox_wireless.jpg"));
        categoria10.setProdutos(produtosCategoria10);
        categoriaProduto.add(categoria10);

        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Produto 1", "Descricao produto 1", 9.99, categoriaProduto, "img_produto_xbox_one.jpg"));
        produtos.add(new Produto("Produto 2", "Descricao produto 2", 9.99, categoriaProduto, "img_produto_controle_xbox_wireless.jpg"));
        produtos.add(new Produto("Produto 3", "Descricao produto 3", 9.99, categoriaProduto, "img_produto_console_wiiU_balck_deluxe_32g.jpg"));
        produtos.add(new Produto("Produto 4", "Descricao produto 4", 9.99, categoriaProduto, "img_produto_game_wolfenstein.jpg"));

        request.setAttribute("categorias", categoriaProduto);
        request.setAttribute("produtos", produtos);

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("WEB-INF/pages/ListarProdutos.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
