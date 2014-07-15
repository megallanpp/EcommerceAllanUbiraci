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
@WebServlet(name = "ServletProdutoController", urlPatterns = {"/produtofc"})
public class ServletProdutoController extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;

    private void incluir() throws RollbackFailureException, PreexistingEntityException, ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        ProdutoJpaController produtoDAO = new ProdutoJpaController(emf);

        Produto produto = new Produto();
        produto.setNome(request.getParameter("nome"));
        produto.setDescricao(request.getParameter("descricao"));
        produto.setNomeArquivoImagem(request.getParameter("nomearquivoimagem"));

        double valor;
        try {
            valor = Double.parseDouble(request.getParameter("valor"));
            produto.setValor(valor);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Valor com formato incorreto.");
            this.listar();
            return;
        }

        produtoDAO.create(produto);

        request.setAttribute("success", "Produto criado com sucesso");
        this.listar();
    }

    private void listar() throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        ProdutoJpaController produtoDAO = new ProdutoJpaController(emf);
        request.setAttribute("produtos", produtoDAO.findProdutoEntities());

        CategoriaJpaController categoriaDAO = new CategoriaJpaController(emf);
        List<Categoria> listNaoOrdenada = categoriaDAO.findCategoriaEntities();
        Collections.sort(listNaoOrdenada);
        request.setAttribute("categorias", listNaoOrdenada);

        RequestDispatcher rd = request.getRequestDispatcher("/Restrito/Admin/ManterProdutos.jsp");
        rd.forward(request, response);
    }

    private void alterar(Long id) throws ServletException, IOException, RollbackFailureException, PreexistingEntityException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        ProdutoJpaController produtoDAO = new ProdutoJpaController(emf);
        CategoriaProdutoJpaController categoriaProdutoDAO = new CategoriaProdutoJpaController(emf);

        Produto produto = produtoDAO.findProduto(id);

        Long idcategoria = Long.parseLong(request.getParameter("idcategoria"));

        if (idcategoria == 0) {
            produto.setNome(request.getParameter("nome"));
            produto.setDescricao(request.getParameter("descricao"));
            
            double valor;
            try {
                valor = Double.parseDouble(request.getParameter("valor"));
                produto.setValor(valor);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "Valor com formato incorreto.");
                this.listar();
                return;
            }
        }

        if (idcategoria != 0) {
            CategoriaJpaController categoriaDAO = new CategoriaJpaController(emf);
            Categoria categoria = categoriaDAO.findCategoria(idcategoria);
            CategoriaProduto categoriaProduto = new CategoriaProduto(categoria, produto);
            categoriaProduto.setDataInclusao(new Date());
            categoriaProdutoDAO.create(categoriaProduto);
        }

        try {
            produtoDAO.edit(produto);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("success", "Produto alterada com sucesso");
        this.listar();
    }

    private void excluir(Long id) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceAllan_UbiraciPU");
        ProdutoJpaController produtoDAO = new ProdutoJpaController(emf);
        try {
            produtoDAO.destroy(id);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(ServletProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("success", "Produto excluído com sucesso");
        this.listar();
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
            Logger.getLogger(ServletProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
