package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controllers.Login;
import views.DropdownView;
import controllers.CadastroFabricante;
import controllers.ConexaoBD;

public class FabricanteModel {
	private int cod_fabricante;
	private String fabricante;
	
	public Statement stm;
	public ResultSet rs;
	
	//DropdownView drop = new DropdownView();
	ConexaoBD conexao = new ConexaoBD();
	
	public boolean Cadastro() {
		conexao.conexao();
		try {	
			PreparedStatement pst = conexao.con.prepareStatement("INSERT INTO fabricante (fabricante) VALUES (?);");
			pst.setString(1, this.getFabricante());
			//pst.setString(5, this.getSenha_confirmacao());
			pst.execute();
			conexao.desconecta();
			return true;
			//JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO");
		} catch (SQLException e) {
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}
		conexao.desconecta();
		return false;
	}
	
	public List<FabricanteModel> getList() {
		FabricanteModel fab = null;
		List<FabricanteModel> fabricanteList = new ArrayList <FabricanteModel>();
		conexao.conexao();
		String count;
		try {		
			stm = conexao.con.createStatement();
			rs = stm.executeQuery("SELECT * FROM FABRICANTE");
		    while(rs.next()) {
		    	fab = new FabricanteModel();		    	
		    	fab.setCod_fabricante(rs.getInt("cod_fabricante"));
		    	fab.setFabricante(rs.getString("fabricante"));
		    	fabricanteList.add(fab);
		    	fab = null;			    
		    }		    
		} catch (SQLException e) {
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}finally{
			conexao.desconecta();
			return fabricanteList;
		}
	}
	
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getCod_fabricante() {
		return cod_fabricante;
	}

	public void setCod_fabricante(int cod_fabricante) {
		this.cod_fabricante = cod_fabricante;
	}
	
}