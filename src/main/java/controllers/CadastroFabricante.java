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

@WebServlet("/cadastro-fabricante")
public class CadastroFabricante extends HttpServlet {	
	FabricanteModel fab = new FabricanteModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.      
    	HttpSession session = request.getSession();
    	boolean logado = Boolean.valueOf(String.valueOf(session.getAttribute("logado")));
    	if(logado == true) {
    		request.setAttribute("views", "cadastro_fabricante.xhtml");
    		request.getRequestDispatcher("views/index.xhtml").forward(request, response);
    	}else {
    		request.getRequestDispatcher("views/login.xhtml").forward(request, response);
    	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        fab.setFabricante(request.getParameter("fabricante"));
        if(fab.Cadastro()) {
        	session.setAttribute("success", "Fabricante inserido com sucesso");
        	response.sendRedirect("/WebDev/cadastro-fabricante");
        }else {
        	session.setAttribute("success", "Erro ao inserir");
        	response.sendRedirect("/WebDev/cadastro-fabricante");
        }
    }
    
}