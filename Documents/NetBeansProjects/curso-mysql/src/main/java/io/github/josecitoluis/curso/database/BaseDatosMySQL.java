/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.josecitoluis.curso.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author josel
 */
public class BaseDatosMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/ramirez";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static BaseDatosMySQL instance;

    private Connection connection;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        JOptionPane.showMessageDialog(null, "Conexion exitosa");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            JOptionPane.showMessageDialog(null, "Conexion cerrada exitosamenete");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatosMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BaseDatosMySQL getInstance() {
        return instance == null ? new BaseDatosMySQL() : instance;
    }
}
