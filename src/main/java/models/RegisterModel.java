package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controllers.ConexaoBD;
import controllers.Register;

public class RegisterModel {
	
	private String nome;
	private String login;
	private String email;
	private String senha;
	private String senha_confirmacao;
	


	ConexaoBD conexao = new ConexaoBD();
	//Register dados = new Register();

	public void Salvar() {
		conexao.conexao();
		try {
			PreparedStatement pst = conexao.con.prepareStatement("INSERT INTO USUARIOS (nome, login, email, senha, senha_confirmacao) VALUES (?,?,?,?,?)");
			pst.setString(1, getNome());
			pst.setString(2, getLogin());
			pst.setString(3, getEmail());
			pst.setString(4, getSenha());
			pst.setString(5, getSenha_confirmacao());
			pst.execute();
			JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO AO INSERIR:\n" + e.getMessage());
		}
		conexao.desconecta();
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
