package DAO;

import factory.Factory;
import model.Produto;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDao {

	public void insertProduto(int ID, String nome, String desc, double preco, int quant, java.util.Date validade) {
		Date data = null;
		if(validade!=null) {
			data = converteData(validade);
		}
		String sql = "INSERT INTO produtos(ID,NOME,DESCRICAO,PRECO,QUANTIDADE,VALIDADE) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = Factory.c.prepareStatement(sql);
			ps.setInt(1, ID);
			ps.setString(2, nome);
			ps.setString(3, desc);
			ps.setDouble(4, preco);
			ps.setInt(5, quant);
			ps.setDate(6, data);
			ps.execute();
		}catch(SQLException e) {
			if(!(e.getMessage().contains("Duplicate"))){
				System.out.println("ERRO AO INSERIR PRODUTO "+nome+"! (method insertProduto())");
				System.out.println(e.getMessage());
			}
		}
	}
	
	private Date converteData(java.util.Date data){
		return new Date(data.getTime());
	}
	
	
	public void updateQuant(int ID, int quant){
		String sql = "UPDATE produtos SET QUANTIDADE = "+quant;
		try {
			PreparedStatement ps =Factory.c.prepareStatement(sql);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("ERRO AO ATUALIZAR A TABELA! (method updateQuant())");
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Produto> getProdutos(){
		ArrayList<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produtos";
		
		try {
			PreparedStatement ps = Factory.c.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getDate(6),0);
				produtos.add(produto);
			}
			return produtos;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER PRODUTO! (method getProdutos())");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Produto getProdutosPorId(int id) {
		Produto produto = null;
		String sql = "SELECT * FROM produtos WHERE id = ?";

		try {
			PreparedStatement ps = Factory.c.prepareStatement(sql);
			ps.setInt(1,id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				produto = new Produto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getDate(6),0);
				if(!rs.next()) return produto;
			}
			return produto;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER PRODUTO! (method getProdutos())");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Produto> listaProdutoPorNome(String nome){
		List<Produto> produtos = new ArrayList();
		String nomeSql = "%"+nome+"%";
		String sql = "SELECT ID, NOME FROM produtos WHERE NOME LIKE ?";

		try {
			PreparedStatement ps = Factory.c.prepareStatement(sql);
			ps.setString(1,nomeSql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				produtos.add(new Produto(rs.getInt(1),rs.getString(2)));
				if(!rs.next()) return produtos;
			}
			return produtos;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER PRODUTO! (method getProdutos())");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
