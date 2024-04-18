package com.ebrain.springboot.demo.demo.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import com.ebrain.springboot.demo.demo.dto.User;

@Repository
public class UserRepository {

	private Connection connection;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if(!ObjectUtils.isEmpty(connection)) {
			return connection;
		}

            return connection;
	    }
	
	public void save(User user) {
			
	}
	public List<User> getAllUser() {
		
		return null; 
	}

}
