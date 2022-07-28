package DAO;


import factory.Factory;
import model.Usuario;

import java.sql.*;

public class UsuarioDao {

    public String inserirUsuario(String nome,String cpf,String senha, String cep,String endereco) {

        String comando = "INSERT INTO USUARIOS (NOME, CPF, SENHA, CEP, ENDERECO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Factory.c.prepareStatement(comando)) {
            pstm.setString(1, nome);
            pstm.setString(2, cpf);
            pstm.setString(3, senha);
            pstm.setString(4, cep);
            pstm.setString(5, endereco);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "O usuário foi inserido.";
    }


    public Usuario consultarUsuarioPorCpf (String cpf)  {
        Usuario usuarioRetornado = new Usuario();
        String sql = "SELECT NOME, CPF, SENHA, CEP, ENDERECO FROM USUARIOS WHERE CPF = ?";
        try(PreparedStatement pstm = Factory.c.prepareStatement(sql)){
            pstm.setString(1,cpf);
            pstm.execute();
            ResultSet rst = pstm.getResultSet();
                while (rst.next()) {
                    String nomeUsuario = rst.getString("NOME");
                    String cpfUsuario = rst.getString("CPF");
                    String senhaUsuario = rst.getString("SENHA");
                    String cepUsuario = rst.getString("CEP");
                    String enderecoUsuario = rst.getString("ENDERECO");
                    usuarioRetornado=(new Usuario(nomeUsuario,cpfUsuario,senhaUsuario,cepUsuario,enderecoUsuario));

                }
            return usuarioRetornado;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());

        }
        return usuarioRetornado;
    }

    public void deletarPorCpf(String cpf) {
        try (PreparedStatement pstm = Factory.c.prepareStatement("DELETE FROM USUARIOS WHERE CPF = " +cpf)){
            pstm.execute();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
