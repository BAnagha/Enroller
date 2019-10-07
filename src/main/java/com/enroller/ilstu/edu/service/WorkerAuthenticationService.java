/**
 * 
 */
package com.enroller.ilstu.edu.service;

import java.util.List;
import com.enroller.ilstu.edu.model.WorkerAuthentication;


/**
 * @author akbhide
 *
 */
public interface WorkerAuthenticationService {
	
	WorkerAuthentication authenticateWorker(String username, String password);
	
	List<WorkerAuthentication> getAllWorkers();
	
	WorkerAuthentication getAuthenticationByUsername(String username);

}
