package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.FabricanteModel;
import models.ModeloModel;

@WebServlet("/cadastro-modelo")
@ManagedBean
@ViewScoped
public class CadastroModelo extends HttpServlet {
	ModeloModel modelo = new ModeloModel();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
    	HttpSession session = request.getSession();
    	boolean logado = Boolean.valueOf(String.valueOf(session.getAttribute("logado")));
    	if(logado == true) {
    		request.setAttribute("views", "cadastro_modelo.xhtml");
    		request.getRequestDispatcher("views/index.xhtml").forward(request, response);
    	}else {
    		request.getRequestDispatcher("views/login.xhtml").forward(request, response);
    	}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		modelo.setCod_modelo(Integer.parseInt(request.getParameter("cod_fabricante")));
		modelo.setModelo(request.getParameter("modelo"));
		if (modelo.Cadastro()) {
			session.setAttribute("success", "Modelo inserido com sucesso");
			response.sendRedirect("/WebDev/cadastro-modelo");
		} else {
			session.setAttribute("success", "Erro ao inserir");
			response.sendRedirect("/WebDev/cadastro-modelo");
		}
	}

	public void submit() {
		System.out.println("submit");
	}

}