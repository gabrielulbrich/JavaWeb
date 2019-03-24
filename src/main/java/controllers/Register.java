package controllers;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import controllers.ConexaoBD;
import models.RegisterModel;

@WebServlet("/register")
public class Register extends HttpServlet {
	RegisterModel model = new RegisterModel();
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.
        request.getRequestDispatcher("views/register.xhtml").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	model.setNome(request.getParameter("nome"));
    	model.setLogin(request.getParameter("login"));
    	model.setEmail(request.getParameter("email"));
    	model.setSenha(request.getParameter("senha"));
    	model.setSenha_confirmacao(request.getParameter("senha_confirmacao"));
    	
		if (model.Salvar()) {
			HttpSession session = request.getSession();
			session.setAttribute("mensagem", model.getNome()+" cadastrado com sucesso!");
			response.sendRedirect("/WebDev/login");
		} else {
			invalidaSessao(request, response);
		}
    }
    
	public static void invalidaSessao(HttpServletRequest 
			request, HttpServletResponse response) 
					throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		request.setAttribute("mensagem", "Erro ao se cadastrar");
		request.getRequestDispatcher("views/register.xhtml").forward(request, response);
	}
  
}