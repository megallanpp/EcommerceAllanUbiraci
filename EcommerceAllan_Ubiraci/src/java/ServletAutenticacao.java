/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dominio.Perfil;
import Dominio.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/ServletAutenticacao"})
public class ServletAutenticacao extends HttpServlet {


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
        String username = request.getParameter("username"); 
        String password = request.getParameter("password"); 
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        RequestDispatcher rd = null; 
        //request.setAttribute(username, "username"); vai ser um atributo da requisicao
        request.getSession().setAttribute("username",username);//getssession cria se nao tiver
        Object obj = request.getSession().getAttribute("contador");
        if(obj == null)
            request.getSession().setAttribute("contador",0);
        
        //FUTURAMENTE OBTER DA BASE
        Pessoa usuario = new Pessoa();
        usuario.setLogin("admin");
        usuario.setSenha("admin");        
        Perfil perfil = new Perfil();
        perfil.setNomePerfil("admin");
        perfil.setPessoa(usuario);
        usuario.setPerfil(perfil);
        
        String sValor = request.getSession().getAttribute("contador").toString(); 
        int iValor =  Integer.parseInt(sValor);
        iValor = iValor + 1;
        request.getSession().setAttribute("contador", iValor); 
        if(username.equals(usuario.getLogin()) && password.equals(usuario.getSenha()))
        { 
            request.getSession().setAttribute("logado",true);
            
            if(usuario.getPerfil().getNomePerfil().equals("admin"))
            { 
                request.getSession().setAttribute("admin",true);
            }
            
            rd = request.getRequestDispatcher("/categoriaprodutofc?tipo=listar"); 
            rd.forward(request, response); 
        } 
        else{ out.println("<b>Login invalido ou senha incorreta</b><br>"); 
            rd = request.getRequestDispatcher("/AcessoNegado.jsp"); 
            rd.include(request, response); 
        } 
        out.close();

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
