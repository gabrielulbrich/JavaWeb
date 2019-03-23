package controllers;

import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

public class ConexaoBD {
	
	public Statement stm;
	public ResultSet rs;
	private String caminho = "jdbc:hsqldb:file:banco/biblioteca";
	private String usuario = "SA";
	private String senha = "";
	public Connection con;

	public void conexao() { //METODO RESPOSAVEL POR REALIZAR CONEXAO COM O BD
		
		try {
			//System.setProperty("jdbc.Drivers", driver);
			con = DriverManager.getConnection(caminho, usuario, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO: Conexao com o banco falhou:\n"+e.getMessage());
		}
	}
	
	public void executaSql(String sql) {
		try {
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO ao executar SQL:\n"+e.getMessage());
		}
	}
	
	public void desconecta() { //METODO RESPONSAVEL PARA DESCONECTAR DO BANCO
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO ao fechar conexao com BD:\n"+e.getMessage());
		}
	}	
}
