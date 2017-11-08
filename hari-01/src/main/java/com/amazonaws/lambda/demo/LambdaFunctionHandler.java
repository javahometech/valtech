package com.amazonaws.lambda.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<String, String> {
	private static final String USER_NAME = "USER_NAME";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://javahome.cqx1rqbejdw5.us-west-2.rds.amazonaws.com:3306/javahome";
	private static final String JDBC_USER_NAME = "javahome";
	private static final String JDBC_PASSWORD = "javahome";
	
	static {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String handleRequest(String input, Context context) {
		context.getLogger().log("Input: " + input);
		try(Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)) {
			String sql = "INSERT INTO EMPLOYEES(EMP_ID,EMP_NAME) VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Hari Kammana");
			int status  =pstmt.executeUpdate();
			System.out.println("Recordes Updated "+status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Welcome from Lambda " + System.getenv(USER_NAME);
	}
}
