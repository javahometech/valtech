package com.amazonaws.lambda.employeecrud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateEmployeeLambda implements RequestHandler<Employee, String> {

	private static final StringBuffer sql = new StringBuffer("INSERT INTO EMPLOYEES ")
			.append(" (EMP_ID, EMP_NAME, EMAIL )").append(" VALUES (?,?,?)");

	@Override
	public String handleRequest(Employee emp, Context context) {
		try (Connection con = RDSUtil.getRDSConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmail());
			pstmt.executeUpdate();
			return "Successfully added";
		} catch (Exception e) {
			e.printStackTrace();

			return "Error adding employee";
		}

	}

}
