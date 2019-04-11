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
public class VeiculoController extends HttpServlet {
	
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
    }
}