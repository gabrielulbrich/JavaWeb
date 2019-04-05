package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

import controllers.Login;
import controllers.ConexaoBD;

public class ModeloModel {
	private String modelo;
	private int cod_modelo;
	
	public Statement stm;
	public ResultSet rs;
	
	
	ConexaoBD conexao = new ConexaoBD();
	
	public boolean Cadastro() {
		conexao.conexao();
		try {	
			PreparedStatement pst = conexao.con.prepareStatement("INSERT INTO MODELO (modelo, cod_fabricante) VALUES (?,?);");
			pst.setString(1, this.getModelo());
			pst.setInt(2, this.getCod_modelo());
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCod_modelo() {
		return cod_modelo;
	}

	public void setCod_modelo(int cod_modelo) {
		this.cod_modelo = cod_modelo;
	}
	
}