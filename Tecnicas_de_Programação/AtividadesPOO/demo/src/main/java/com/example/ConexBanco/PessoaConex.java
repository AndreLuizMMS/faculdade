package com.example.ConexBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.ConnectionDB;
import com.example.Objs.Pessoa;

public class PessoaConex {

  public static void incluirPessoa(Pessoa pessoa) {
    System.out.println("Incluindo pessoa...");
    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "INSERT INTO Pessoa (nome, profissao_id) VALUES (?, ?)";

    try {
      conn = ConnectionDB.connectToDB();
      pstm = conn.prepareStatement(sql);

      pstm.setString(1, pessoa.getNome());
      pstm.setInt(2, pessoa.getProfissao());

      pstm.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {
        if (pstm != null) {
          pstm.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void listarPessoas() {
    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "SELECT * FROM Pessoa, Telefone ";

    try {
      conn = ConnectionDB.connectToDB();
      pstm = conn.prepareStatement(sql);

      ResultSet resultSet = pstm.executeQuery();

      System.out.println("Profissões: ");
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        int pessoa_id = resultSet.getInt("pessoa_id");
        String nome = resultSet.getString("nome");
        String numero = resultSet.getString("numero");

        if (pessoa_id == id) {
          System.out.print("ID: " + id);
          System.out.print(" | Nome: " + nome);
          System.out.print(" | Telefone: " + numero);
          System.out.println();
        }
      }

    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {
        if (pstm != null) {
          pstm.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void excluirPessoa(int id) {
    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "DELETE FROM Pessoa WHERE id = ?";

    try {
      conn = ConnectionDB.connectToDB();
      pstm = conn.prepareStatement(sql);

      pstm.setInt(1, id);

      pstm.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {
        if (pstm != null) {
          pstm.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void excluirPessoa(String nome) {
    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "DELETE FROM Pessoa WHERE nome = ?";

    try {
      conn = ConnectionDB.connectToDB();
      pstm = conn.prepareStatement(sql);

      pstm.setString(1, nome);

      pstm.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {
        if (pstm != null) {
          pstm.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
