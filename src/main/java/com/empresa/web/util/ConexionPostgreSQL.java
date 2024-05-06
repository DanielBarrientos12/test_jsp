package com.empresa.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPostgreSQL {
	
	private static Connection con = null;
    private static ConexionPostgreSQL instance;
    private PreparedStatement preparedStatement;
    
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String DB_NAME = "sistema";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "824619";
    
    private ConexionPostgreSQL() {
        try {
            Class.forName(DRIVER);
            String connectionUrl = URL + DB_NAME + "?user=" + USERNAME + "&password=" + PASSWORD;
            con = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized ConexionPostgreSQL getConexion() {
        if (instance == null) {
            instance = new ConexionPostgreSQL();
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
