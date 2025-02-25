/**
 * 
 */
package com.enroller.ilstu.edu.model;

/**
 * @author akbhide
 *
 */
public class WorkerAuthentication {
	
	private Long id;
	private String username;
	private String password;
	private String role;
	private Long empId;
	
	public WorkerAuthentication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkerAuthentication(Long id, String username, String password, String role, Long empId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.empId = empId;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "WorkerAuthentication [id=" + id + ",role=" + role + ", username=" + username + ", password=" + password + ",  empId=" + empId+ "]";
	}

}
