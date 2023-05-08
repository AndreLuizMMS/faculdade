package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/migoscode", "postgres", "root");

            if (conn != null) {
                System.out.println("Connected to the database!");
                Statement stm = conn.createStatement();
                fetchData(stm);
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void fetchData(Statement stm) {
        String query = "SELECT first_name FROM person;";
        try {
            ResultSet result = stm.executeQuery(query);

            while (result.next()) {
                System.out.println(result.getString("first_name"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
