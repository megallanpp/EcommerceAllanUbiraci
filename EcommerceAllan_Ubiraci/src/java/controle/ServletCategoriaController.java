package controle;

import Dominio.Categoria;
import controle.DAO.CategoriaJpaController;
import controle.DAO.exceptions.PreexistingEntityException;
import controle.DAO.exceptions.RollbackFailureException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
@WebServlet(name = "ServletCategoriaController", urlPatterns = {"/categoriafc"})
public class ServletCategoriaController extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    javax.servlet.http.HttpSession session;
    
    private void incluir() throws RollbackFailureException, PreexistingEntityException, ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaJpaController categoriaDAO = new CategoriaJpaController(emf);

        Categoria categoria = new Categoria();
        categoria.setNome(request.getParameter("nome"));
        categoriaDAO.create(categoria);
//        request.setAttribute("success", "Categoria criada com sucesso");
        session.setAttribute("success", "Categoria criada com sucesso");
        this.listar();
    }

    private void listar() throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaJpaController categoriaDAO = new CategoriaJpaController(emf);
        request.setAttribute("categorias", categoriaDAO.findCategoriaEntities());
        
//        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/ListarCategorias.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/Restrito/Admin/ManterCategorias.jsp");
        rd.forward(request, response);
    }

    private void alterar(Long id) throws ServletException, IOException  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaJpaController categoriaDAO = new CategoriaJpaController(emf);
        Categoria categoria = categoriaDAO.findCategoria(id);
        categoria.setNome(request.getParameter("nome"));
        try {
            categoriaDAO.edit(categoria);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletCategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("success", "Categoria alterada com sucesso");
        this.listar();
    }

    private void excluir(Long id) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaJpaController categoriaDAO = new CategoriaJpaController(emf);
        try {
            categoriaDAO.destroy(id);
            request.setAttribute("success", "Categoria excluida.");
            listar();
        }catch (RollbackFailureException ex) {
            request.setAttribute("error", "Impossivel excluir registro");
            listar();
            Logger.getLogger(ServletCategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex){
            request.setAttribute("error", "Impossivel excluir registro");
            listar();
            
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
            Logger.getLogger(ServletCategoriaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletCategoriaController.class.getName()).log(Level.SEVERE, null, ex);
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
