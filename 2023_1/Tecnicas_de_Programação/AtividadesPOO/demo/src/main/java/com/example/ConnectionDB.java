package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

  public static Connection connectToDB() {

    Connection conn = null;

    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "vicente";
    String user = "deds";
    String password = "password";

    try {
      conn = DriverManager.getConnection(url + dbName, user, password);
      System.out.println("connected");
    } catch (Exception ex) {
      System.out.println("SQLException: " + ex.getMessage());
    }

    return conn;
  }
}
