package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controllers.Login;
import controllers.ConexaoBD;

public class LoginModel {
	private String nome;
	private String login;
	private String email;
	private String senha;
	
	
	public Statement stm;
	public ResultSet rs;
	
	
	ConexaoBD conexao = new ConexaoBD();
	
	public void Login() {
		conexao.conexao();
		try {		
			PreparedStatement pst = conexao.con.prepareStatement("SELECT * FROM USUARIOS WHERE");
			//pst.setString(1,mod.getNome());
			pst.execute();
			JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO AO INSERIR:\n"+e.getMessage());
		}
		conexao.desconecta();
	}
	
	public boolean LoginExiste() {
		conexao.conexao();
		String count;
		try {		
			stm = conexao.con.createStatement();
			rs = stm.executeQuery("SELECT * FROM USUARIO WHERE login='"+this.getLogin()+"';");
		    if(rs.next()) {
		        this.setNome(rs.getString("nome"));
		        this.setLogin(rs.getString("login"));
		        this.setEmail(rs.getString("email"));
		        this.setSenha(rs.getString("senha"));
			    conexao.desconecta();
		        return true;
		    }else {
			    conexao.desconecta();
		    	return false;
		    }
		} catch (SQLException e) {
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}
		return false;
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
}