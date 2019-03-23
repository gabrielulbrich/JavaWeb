package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controllers.ConexaoBD;
import controllers.Register;

public class RegisterModel {
	ConexaoBD conexao = new ConexaoBD();
	//Register dados = new Register();

	public void Salvar(Register dados) {
		conexao.conexao();
		try {
			PreparedStatement pst = conexao.con.prepareStatement("INSERT INTO categoria (nome, login, email, senha, senha_confirmacao) VALUES (?,?,?,?,?)");
			pst.setString(1, dados.getNome());
			pst.setString(2, dados.getLogin());
			pst.setString(3, dados.getEmail());
			pst.setString(4, dados.getSenha());
			pst.setString(5, dados.getSenha_confirmacao());
			pst.execute();
			JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO AO INSERIR:\n" + e.getMessage());
		}
		conexao.desconecta();
	}
}
