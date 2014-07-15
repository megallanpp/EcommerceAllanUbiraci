/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author allan
 */
@WebServlet(name = "ServletUpload", urlPatterns = {"/upload"})
@MultipartConfig
public class ServletUpload extends HttpServlet {

//    private final String UPLOAD_DIRECTORY = "C:/uploads";
    private final String UPLOAD_DIRECTORY = "C:/Users/allan/Documents/GitHub/EcommerceAllanUbiraci/EcommerceAllan_Ubiraci/web/resources/uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;

        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                String idproduto = request.getParameter("idproduto"); // Retrieves <input type="text" name="status">
                Part partfile = request.getPart("file"); // Retrieves <input type="file" name="file">
                InputStream content = partfile.getInputStream();

                Date datacriacaoarquivo = new Date();
//                SimpleDateFormat formatoData = new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String dataFormatada = formatoData.format(datacriacaoarquivo);
                String dSemCaracEspeciais = dataFormatada.replace(':', '_');
                dSemCaracEspeciais = dSemCaracEspeciais.replace('/', '_');
                String outputfile = dSemCaracEspeciais + "_img_" + partfile.getSubmittedFileName();
                FileOutputStream os = new FileOutputStream(UPLOAD_DIRECTORY + File.separator + outputfile);

                // write bytes taken from uploaded file to target file
                int ch = content.read();
                while (ch != -1) {
                    os.write(ch);
                    ch = content.read();
                }
                os.close();

                request.setAttribute("filepath", outputfile);

//                List<FileItem> multiparts = new ServletFileUpload(
//                        new DiskFileItemFactory()).parseRequest((RequestContext) request);
//                
//                for (FileItem item : multiparts) {
//                    if (!item.isFormField()) {
//                        String name = new File(item.getName()).getName();
//                        File file = new File(UPLOAD_DIRECTORY + File.separator + name);
//                        item.write(file);
//                        request.setAttribute("filepath", file.getPath());
//                    } else {
//                        //here...
//                        String fieldname = item.getFieldName();
//                        String fieldvalue = item.getString();
//                        if (fieldname.equals("idproduto")) {
//                            idproduto = request.getParameter("idproduto");
//                        } else if (fieldname.equals("upload_wall_gallery")) {
//                            //next logic goes here...
//                        }
//                    }
//                }
                //File uploaded successfully
                request.setAttribute("success", "Arquivo enviado com sucesso");

                rd = request.getRequestDispatcher("/produtofc?tipo=alterar&id=" + idproduto);
                rd.forward(request, response);
            } catch (Exception ex) {
                request.setAttribute("error", "Não foi possível enviar arquivo: " + ex);
            }

        } else {
            request.setAttribute("error",
                    "Este servlet somente trata requisições de upload de arquivos");
        }

        rd = request.getRequestDispatcher("/Restrito/Admin/ManterProdutos.jsp");

        rd.forward(request, response);
    }
}
