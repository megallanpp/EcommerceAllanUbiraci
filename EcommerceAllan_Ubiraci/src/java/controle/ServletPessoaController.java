package controle;

import Dominio.Pessoa;
import controle.DAO.PessoaJpaController;
import controle.DAO.exceptions.RollbackFailureException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
@WebServlet(name = "ServletPessoaController", urlPatterns = {"/ServletPessoaController"})
public class ServletPessoaController extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    
    private void incluir() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        PessoaJpaController pessoaDAO = new PessoaJpaController(emf);

        Pessoa pessoa = new Pessoa();
        try {
            pessoa.setNome(null);
            pessoaDAO.create(pessoa);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletPessoaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServletPessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        PessoaJpaController pessoaDAO = new PessoaJpaController(emf);
        for (Pessoa pessoa : pessoaDAO.findPessoaEntities()) {
            System.out.println(pessoa.getId());
        }
    }

    private void alterar(Long id)  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        PessoaJpaController pessoaDAO = new PessoaJpaController(emf);
        Pessoa pessoa = pessoaDAO.findPessoa(id);
        pessoa.setNome("NOVONOME");
        try {
            pessoaDAO.edit(pessoa);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletPessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void excluir(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        PessoaJpaController pessoaDAO = new PessoaJpaController(emf);
        try {
            pessoaDAO.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletPessoaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletPessoaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletPessoaController.class.getName()).log(Level.SEVERE, null, ex);
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
