package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.FabricanteModel;
import models.ModeloModel;

@WebServlet("/cadastro-modelo")
public class CadastroModelo extends HttpServlet {
	ModeloModel modelo = new ModeloModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.
    	request.setAttribute("views", "cadastro_modelo.xhtml");
        request.getRequestDispatcher("views/index.xhtml").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        modelo.setModelo(request.getParameter("fabricante"));
        if(modelo.Cadastro()) {
        	session.setAttribute("success", "Modelo inserido com sucesso");
        	response.sendRedirect("/WebDev/cadastro-modelo");
        }else {
        	session.setAttribute("success", "Erro ao inserir");
        	response.sendRedirect("/WebDev/cadastro-modelo");
        }
    }

}