package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

  public static Connection connectToDB() {

    Connection conn = null;

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vicente", "deds", "password");
      System.out.println("connected");
    } catch (Exception ex) {
      System.out.println("SQLException: " + ex.getMessage());
    }

    return conn;
  }
}
