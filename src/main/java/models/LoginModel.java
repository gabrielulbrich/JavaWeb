package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controllers.Login;
import controllers.ConexaoBD;

public class LoginModel {
	ConexaoBD conexao = new ConexaoBD();
	
	public void Salvar() {
		conexao.conexao();
		try {		
			PreparedStatement pst = conexao.con.prepareStatement("SELECT * FROM ARTISTA");
			//pst.setString(1,mod.getNome());
			pst.execute();
			JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO AO INSERIR:\n"+e.getMessage());
		}
		conexao.desconecta();
	}
}