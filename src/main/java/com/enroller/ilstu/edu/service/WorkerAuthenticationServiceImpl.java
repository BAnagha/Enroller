/*
* Enroller
*
* File name: WorkerAuthenticationServiceImpl.java
*
* Programmer: Anagha Bhide
*
* Date: Apr 28, 2019
*
*/
package com.enroller.ilstu.edu.service;

import java.util.List;

import javax.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.enroller.ilstu.edu.dao.WorkerAuthenticationDAO;
import com.enroller.ilstu.edu.model.WorkerAuthentication;

/**
 * @author akbhide
 *
 */
@ManagedBean
public class WorkerAuthenticationServiceImpl implements WorkerAuthenticationService{

	@Autowired
	WorkerAuthenticationDAO workerAuthenticationDAO;
	
	/* (non-Javadoc)
	 * @see com.illinoisstate.it.service.WorkerAuthenticationService#authenticateWorker(java.lang.String, java.lang.String)
	 */
	@Override
	public WorkerAuthentication authenticateWorker(String username, String password) {
		return workerAuthenticationDAO.authenticateWorker(username, password);
	}

	/* (non-Javadoc)
	 * @see com.illinoisstate.it.service.WorkerAuthenticationService#getAllWorkers()
	 */
	@Override
	public List<WorkerAuthentication> getAllWorkers() {
		return workerAuthenticationDAO.getAllWorkers();
	}

	@Override
	public WorkerAuthentication getAuthenticationByUsername(String username) {
		// TODO Auto-generated method stub
		return workerAuthenticationDAO.getAuthenticationByUsername(username);
	}

}
