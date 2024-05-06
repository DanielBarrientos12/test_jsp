package com.empresa.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    
    private static Connection con = null;
    private static Conexion instance;
    private PreparedStatement preparedStatement;
    
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "sistema";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "824619";

    private Conexion() {
        try {
            Class.forName(DRIVER);
            // Formando correctamente la URL de conexión
            String connectionUrl = URL + DB_NAME + "?user=" + USERNAME + "&password=" + PASSWORD;
            con = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized Conexion getConexion() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }
    
    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet query() throws SQLException {
        return preparedStatement.executeQuery();
    }
    
    public int execute() throws SQLException {
        return preparedStatement.executeUpdate();
    }
    
    public Connection getCon() {
        return con;
    }
    
    public PreparedStatement setPreparedStatement(String sql) throws SQLException {
        preparedStatement = con.prepareStatement(sql);
        return preparedStatement;
    }
}
