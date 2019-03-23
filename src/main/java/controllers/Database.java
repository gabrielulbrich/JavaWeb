package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	Connection conn;
	
	public Database() throws Exception{
		conn = DriverManager.getConnection("jdbc:hsqldb:file:banco/biblioteca",
										   "SA",
										   "");
	}

	public synchronized void query(String expression) throws SQLException
	{
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		rs = st.executeQuery(expression);
		dump(rs);
		st.close();
	}

	public synchronized void update(String expression) throws SQLException 
	{
		Statement st = null;
		st = conn.createStatement(); 
		int i = st.executeUpdate(expression);
			if (i == -1)
			{
				System.out.println("db error : " + expression);
			}

		st.close();
	}

	public void shutdown() throws SQLException 
	{
		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
		conn.close(); // if there are no other open connection
	}
	
	public static void dump(ResultSet rs) throws SQLException 
	{
		// faz o 'get' em todos os dados recuperados na query
		ResultSetMetaData meta = rs.getMetaData();
		int colmax = meta.getColumnCount(); // retorna a quantidade de colunas
		int i;
		Object o = null;
		// o primeiro for percorre todas as linhas retornadas pela query
		for (; rs.next(); ) {
		// o segundo for percorre todas as colunas de uma linha x
		for (i = 0; i < colmax; ++i) {
		// retorna o objeto da coluna percorrida naquele momento
		o = rs.getObject(i+1);
		System.out.print(o.toString() + " ");
		}
		System.out.println(" ");
		}
	}
} // class Testdb
		
		
