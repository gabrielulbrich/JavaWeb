package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controllers.Login;
import controllers.ConexaoBD;

public class FabricanteModel {
	private String fabricante;
	
	public Statement stm;
	public ResultSet rs;
	
	
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
	
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
}