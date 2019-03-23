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
	
	private String nome;
	private String login;
	private String email;
	private String senha;
	private String senha_confirmacao;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.
        request.getRequestDispatcher("views/register.xhtml").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    	setNome(request.getParameter("nome"));
    	setLogin(request.getParameter("login"));
    	setEmail(request.getParameter("email"));
    	setSenha(request.getParameter("senha"));
    	setSenha_confirmacao(request.getParameter("senha_confirmacao"));
    	
    	//model.Salvar();
    	
		if (nome != null &&	senha != null) {
			HttpSession session = request.getSession();
			session.setAttribute("mensagem", nome+" cadastrado com sucesso!");
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
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha_confirmacao() {
		return senha_confirmacao;
	}

	public void setSenha_confirmacao(String senha_confirmacao) {
		this.senha_confirmacao = senha_confirmacao;
	}

}