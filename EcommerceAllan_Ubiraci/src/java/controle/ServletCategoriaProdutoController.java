package controle;

import Dominio.Categoria;
import Dominio.CategoriaProduto;
import Dominio.Produto;
import controle.DAO.CategoriaJpaController;
import controle.DAO.CategoriaProdutoJpaController;
import controle.DAO.ProdutoJpaController;
import controle.DAO.exceptions.PreexistingEntityException;
import controle.DAO.exceptions.RollbackFailureException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "ServletCategoriaProdutoController", urlPatterns = {"/categoriaprodutofc"})
public class ServletCategoriaProdutoController extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;

    private void incluir() throws ServletException, IOException, RollbackFailureException, PreexistingEntityException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaProdutoJpaController categoriaProdutoDAO = new CategoriaProdutoJpaController(emf);
        CategoriaJpaController categoriaDAO = new CategoriaJpaController(emf);
        ProdutoJpaController produtoDAO = new ProdutoJpaController(emf);

        Categoria categoria = categoriaDAO.findCategoria(Long.parseLong(request.getParameter("idcategoria")));
        Produto produto = produtoDAO.findProduto(Long.parseLong(request.getParameter("idproduto")));

        CategoriaProduto categoriaproduto = new CategoriaProduto();
        categoriaproduto.setDataInclusao(new Date());
        categoriaproduto.setProduto(produto);
        categoriaproduto.setCategoria(categoria);
        categoriaProdutoDAO.create(categoriaproduto);
        request.setAttribute("success", "CategoriaProduto criada com sucesso");

        RequestDispatcher rd = request.getRequestDispatcher("/Restrito/Admin/ManterCategorias.jsp");
        rd.forward(request, response);
    }

    private void listar() throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaProdutoJpaController categoriaProdutoDAO = new CategoriaProdutoJpaController(emf);

        List<CategoriaProduto> listNaoOrdenada = categoriaProdutoDAO.findCategoriaProdutoEntities();
//        Collections.sort(listNaoOrdenada);

        List<Categoria> categorias = new ArrayList<Categoria>();
        List<Produto> produtos = new ArrayList<Produto>();

        for (CategoriaProduto categoriaProduto : listNaoOrdenada) {
            Produto produto = categoriaProduto.getProduto();
            Categoria categoria = categoriaProduto.getCategoria();
            categorias.addAll(produto.getCategorias());
            produtos.addAll(categoria.getProdutos());
        }

        request.setAttribute("categorias", categorias);
        request.setAttribute("produtos", produtos);

        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("WEB-INF/pages/ListarProdutos.jsp");
        rd.forward(request, response);
    }

    private void alterar(Long id) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaProdutoJpaController categoriaProdutoDAO = new CategoriaProdutoJpaController(emf);
        CategoriaJpaController categoriaDAO = new CategoriaJpaController(emf);
        ProdutoJpaController produtoDAO = new ProdutoJpaController(emf);

        CategoriaProduto categoriaProduto = categoriaProdutoDAO.findCategoriaProduto(id);

        Long idcategoria = Long.parseLong(request.getParameter("idcategoria"));
        Categoria categoria = categoriaDAO.findCategoria(idcategoria);

        Long idproduto = Long.parseLong(request.getParameter("idproduto"));
        Produto produto = produtoDAO.findProduto(idproduto);

        CategoriaProduto categoriaproduto = new CategoriaProduto();
        categoriaproduto.setDataInclusao(new Date());
        categoriaproduto.setProduto(produto);
        categoriaproduto.setCategoria(categoria);

        try {
            categoriaProdutoDAO.edit(categoriaProduto);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletCategoriaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("success", "CategoriaProduto criada com sucesso");

        RequestDispatcher rd = request.getRequestDispatcher("/Restrito/Admin/ManterCategorias.jsp");
        rd.forward(request, response);
    }

    private void excluir(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaProdutoJpaController categoriaProdutoDAO = new CategoriaProdutoJpaController(emf);
        try {
            categoriaProdutoDAO.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletCategoriaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void excluir(Long idproduto, Long idcategoria) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        CategoriaProdutoJpaController categoriaProdutoDAO = new CategoriaProdutoJpaController(emf);

        List<CategoriaProduto> categoriasprodutos = categoriaProdutoDAO.findCategoriaProdutoEntities();
        try {

            for (CategoriaProduto categoriaProduto : categoriasprodutos) {
                if (categoriaProduto.getCategoria().getId() == idcategoria && categoriaProduto.getProduto().getId() == idproduto) {
                    categoriaProdutoDAO.destroy(categoriaProduto.getId());
                }
            }
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletCategoriaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("success", "CategoriaProduto excluído com sucesso");

        RequestDispatcher rd = request.getRequestDispatcher("/Restrito/Admin/ManterCategorias.jsp");
        rd.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        this.request = request;
        this.response = response;

        String tipo = request.getParameter("tipo") == null ? "listar" : request.getParameter("tipo");
        Long id = request.getParameter("id") == null ? 1l : Long.parseLong(request.getParameter("id"));

        Long idproduto = request.getParameter("idproduto") == null ? 1l : Long.parseLong(request.getParameter("idproduto"));
        Long idcategoria = request.getParameter("idcategoria") == null ? 1l : Long.parseLong(request.getParameter("idcategoria"));

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
        if (tipo.equalsIgnoreCase("excluircomids")) {
            excluir(idproduto, idcategoria);
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
            Logger.getLogger(ServletCategoriaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletCategoriaProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
