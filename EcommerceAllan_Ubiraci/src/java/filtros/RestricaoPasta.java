/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filtros;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bughi
 */
@WebFilter(filterName = "RestricaoPasta", urlPatterns = {"/Restrito/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class RestricaoPasta implements Filter {
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
         HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;
         //chain.doFilter(req, res);
         //res.sendError(403);
         Object obj = req.getSession().getAttribute("logado");
         if(obj == null)
             res.sendRedirect("http://localhost:8084/EcommerceAllan_Ubiraci/AcessoNegado.jsp"); 
         else
             chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        
    }
    
    
}
