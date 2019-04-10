package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.VeiculoModel;

@WebServlet("/cadastro-veiculo")
@ManagedBean
@ViewScoped
public class CadastroVeiculo extends HttpServlet {
	


	private String cod_fabricante;
	private String cod_modelo;
	private String quantidade;
	private String cor;
	private String descricao;
	private String placa;

	VeiculoModel model = new VeiculoModel();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.
    	//request.setAttribute("views", "cadastro_veiculo.xhtml");
    	//request.getRequestDispatcher("views/index.xhtml").forward(request, response);
        request.getRequestDispatcher("views/cadastro_veiculo.xhtml").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println(" ok");
    	
//		HttpSession session = request.getSession();
//		
//		model.setDescricao(request.getParameter("descricao"));
//		model.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
//		model.setCor(request.getParameter("cor"));
//		model.setPlaca(request.getParameter("placa"));
//		model.setCod_modelo(Integer.parseInt(request.getParameter("cod_modelo")));
//		model.setCod_fabricante(Integer.parseInt(request.getParameter("cod_fabricante")));
//		
//		if (model.CadastrarVeiculo()) {
//			session.setAttribute("success", "Modelo inserido com sucesso");
//			response.sendRedirect("/WebDev/cadastro-veiculo");
//		} else {
//			session.setAttribute("success", "Erro ao inserir");
//			response.sendRedirect("/WebDev/cadastro-veiculo");
//		}
    }
    
    public void submit() {    
    	
    	System.out.println(" ok");
    	
    	System.out.println(this.getCod_fabricante());
    	System.out.println(this.getCod_modelo());
    	
//    	int cod_fabriencateInt = Integer.parseInt(this.getCod_fabricante());
//    	int cod_modeloInt = Integer.parseInt(this.getCod_modelo());
//    	int quantidadeInt = Integer.parseInt(this.getQuantidade());
//    	
//    	System.out.println(cod_fabriencateInt);
//    	System.out.println(cod_modeloInt);
//    	System.out.println(this.getDescricao());
//    	System.out.println(quantidadeInt);
//    	System.out.println(this.getCor());
//    	System.out.println(this.getPlaca());
//    	
//		
//    	model.setCod_fabricante(cod_fabriencateInt);
//    	model.setCod_modelo(cod_modeloInt);
//		model.setDescricao(this.getDescricao());
//		model.setQuantidade(quantidadeInt);
//		model.setCor(this.getCor());
//		model.setPlaca(this.getPlaca());
//		
//		if (model.CadastrarVeiculo()) {
//	    	FacesContext facesContext = FacesContext.getCurrentInstance();
//			FacesMessage facesMessage = new FacesMessage("Veiculo inserido com sucesso!");
//			facesContext.addMessage(null, facesMessage);
//		} else {
//	    	FacesContext facesContext = FacesContext.getCurrentInstance();
//			FacesMessage facesMessage = new FacesMessage("ERRO!");
//			facesContext.addMessage(null, facesMessage);
//		}
    }
    
	public String getCod_fabricante() {
		return cod_fabricante;
	}

	public void setCod_fabricante(String cod_fabricante) {
		this.cod_fabricante = cod_fabricante;
	}

	public String getCod_modelo() {
		return cod_modelo;
	}

	public void setCod_modelo(String cod_modelo) {
		this.cod_modelo = cod_modelo;
	}
    
	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
    

}