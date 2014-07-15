package controle;

import Dominio.Perfil;
import controle.DAO.PerfilJpaController;
import controle.DAO.exceptions.RollbackFailureException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
@WebServlet(name = "ServletPerfilController", urlPatterns = {"/ServletPerfilController"})
public class ServletPerfilController extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    
    private void incluir() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        PerfilJpaController perfilDAO = new PerfilJpaController(emf);

        Perfil perfil = new Perfil();
        try {
            perfil.setNomePerfil("NOVONOME");
            perfilDAO.create(perfil);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletPerfilController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServletPerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        PerfilJpaController perfilDAO = new PerfilJpaController(emf);
        for (Perfil perfil : perfilDAO.findPerfilEntities()) {
            System.out.println(perfil.getId());
        }
    }

    private void alterar(Long id)  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        PerfilJpaController perfilDAO = new PerfilJpaController(emf);
        Perfil perfil = perfilDAO.findPerfil(id);
        perfil.setNomePerfil("NOVONOME");
        try {
            perfilDAO.edit(perfil);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletPerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void excluir(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        PerfilJpaController perfilDAO = new PerfilJpaController(emf);
        try {
            perfilDAO.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletPerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        this.request = request;
        this.response = response;
        
        String tipo = request.getParameter("tipo") == null ? "listar" : request.getParameter("tipo");
        Long id = request.getParameter("id") == null ? 1l : Long.parseLong(request.getParameter("id"));

        if (tipo.equalsIgnoreCase("listar")) {
            listar();
        }
        if (tipo.equalsIgnoreCase("incluir")) {
            incluir();
        }
        if (tipo.equalsIgnoreCase("alterar")) {
            alterar(id);
        }
        if (tipo.equalsIgnoreCase("excluir")) {
            excluir(id);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Verifique o banco de dados para validar o teste</h1>");
        
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletPerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletPerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
