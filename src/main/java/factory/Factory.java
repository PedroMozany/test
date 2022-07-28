package factory;

import java.sql.*;

public class Factory {
	public static Connection c;

	static {
		try {
			Class.forName("org.postgresql.Driver");
			String URL = "jdbc:postgresql://ec2-52-204-157-26.compute-1.amazonaws.com:5432/d8u7m23tgtampr?sslmode=require";
			c = DriverManager.getConnection(URL,"qdvzpdjxnuxkka","747bd14fb0de048853d43024a97d4f9bb28bf790623b5cbad327b09828f96214");

		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("ERRO NO CONSTRUTOR DA CLASSE FACTORY!");
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		System.out.println("Fechando conexao com o banco de dados");
		try {
			this.c.close();
		}catch (SQLException e) {
			System.out.println("ERRO AO FECHAR CONEXAO COM BANCO DE DADOS (method closeConnection())");
			System.out.println(e.getMessage());
		}
		
	}
}
