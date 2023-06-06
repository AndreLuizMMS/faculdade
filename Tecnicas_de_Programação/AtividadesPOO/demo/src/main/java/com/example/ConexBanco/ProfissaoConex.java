package com.example.ConexBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.ConnectionDB;
import com.example.Objs.Profissao;

public class ProfissaoConex {

  public static void incluirProfissao(Profissao profissao) {

    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "INSERT INTO Profissao (nome) VALUES (?)";

    try {
      conn = ConnectionDB.connectToDB();
      pstm = conn.prepareStatement(sql);

      pstm.setString(1, profissao.getNome());

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

  public static void listarProfissoes() {
    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "SELECT * FROM Profissao ORDER BY nome";

    try {
      conn = ConnectionDB.connectToDB();
      pstm = conn.prepareStatement(sql);

      ResultSet resultSet = pstm.executeQuery();

      System.out.println("Profissões: ");
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");

        System.out.print("ID: " + id);
        System.out.print(" | Nome: " + nome);
        System.out.println();

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

  public static void excluirProfissao(int id) {
    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "DELETE FROM Profissao WHERE id = ?";

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

  public static void excluirProfissao(String nome) {
    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "DELETE FROM Profissao WHERE id = ?";

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

  public static void alterarProfissao(Profissao profissao) {
    Connection conn = null;
    PreparedStatement pstm = null;

    String sql = "UPDATE Profissao SET nome = ? WHERE id = ?";

    try {
      conn = ConnectionDB.connectToDB();
      pstm = conn.prepareStatement(sql);

      pstm.setString(1, profissao.getNome());

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
