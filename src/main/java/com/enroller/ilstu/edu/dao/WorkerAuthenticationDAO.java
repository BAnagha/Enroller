package com.enroller.ilstu.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import com.enroller.ilstu.edu.model.WorkerAuthentication;
import com.enroller.ilstu.edu.util.MYDb;


/**
 * @author akbhide
 *
 */
@ManagedBean
public class WorkerAuthenticationDAO {
	
	public WorkerAuthentication authenticateWorker(String username, String password) {
		WorkerAuthentication workerAuthentication = new WorkerAuthentication();
		System.out.println("wa in DAO " +workerAuthentication);		

		Connection con = MYDb.getCon();
		String result="";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from admin where username = ? and password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				result = "success";
				workerAuthentication.setId(rs.getLong("admin_id"));
				workerAuthentication.setRole(rs.getString("role"));
				workerAuthentication.setUsername(rs.getString("username"));
				workerAuthentication.setEmpId(rs.getLong("emp_id"));
				System.out.println("wa in DAO " +workerAuthentication);		

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return workerAuthentication;
		
	}
	
	
	public List<WorkerAuthentication> getAllWorkers(){
		List<WorkerAuthentication> workerAuthenticationList = new ArrayList<WorkerAuthentication>();
		
		//Call Db to get list of workers
		return workerAuthenticationList;
	}
	
	
	public WorkerAuthentication getAuthenticationByUsername(String username) {
		WorkerAuthentication workerAuthentication = new WorkerAuthentication();
		
		Connection con = MYDb.getCon();
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from admin where username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				workerAuthentication.setId(Long.parseLong(rs.getString("admin_id")));
				workerAuthentication.setRole(rs.getString("role"));
				workerAuthentication.setUsername(rs.getString("username"));
				workerAuthentication.setEmpId(rs.getLong("emp_id"));
				workerAuthentication.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Add code to access from DB
		
		return workerAuthentication;
		
	}
	

}
