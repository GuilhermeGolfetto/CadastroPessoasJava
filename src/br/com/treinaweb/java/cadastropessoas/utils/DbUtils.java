package br.com.treinaweb.java.cadastropessoas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

	public static Connection getConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Conexão com Banco de Dados
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String stringConexao = "jdbc:mysql://127.0.0.1/treinaweb_jse?user=root&password=root";
		Connection connection = DriverManager.getConnection(stringConexao);
		return connection;
	}

	public static ResultSet getResultSet(Connection conn, String sql) throws SQLException {
		// Usado para os Selects
		Statement statement = conn.createStatement();
		return statement.executeQuery(sql);
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql) throws SQLException {
		// Usado para os Updates,Creates..
		return conn.prepareStatement(sql);
	}
}
