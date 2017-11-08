package com.amazonaws.lambda.employeecrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetEmployeeByIdLambda implements RequestHandler<Integer, Employee> {

	@Override
	public Employee handleRequest(Integer empId, Context context) {
		try (Connection con = RDSUtil.getRDSConnection()) {
			String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			Employee e = new Employee();
			while(rs.next()) {
				e.setEmpName(rs.getString("EMP_NAME"));
				e.setEmail(rs.getString("EMAIL"));
				e.setEmpId(rs.getInt("EMP_ID"));
			}
			return e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
