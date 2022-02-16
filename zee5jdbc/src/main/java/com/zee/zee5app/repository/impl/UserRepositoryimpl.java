package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;

import lombok.Data;
import lombok.NoArgsConstructor;


@Repository
public class UserRepositoryimpl implements UserRepository2 {
	private TreeSet<Register> set = new TreeSet<>();
	// when u will use DC for AL then by default it will hold 16 elements
	// of type Register.
	@Autowired
	DataSource dataSource;
	//private static int count=-1;
	
	@Autowired
	 LoginRepository loginRepository;
	//private static DBUtils dbutils=null;
	@Autowired
	PasswordUtils passwordUtils;
	
	
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		String insertQuery = "insert into register" + "(regId, firstname, lastname, email, password)"
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
			prepStatement.setPoolable(true);
			prepStatement.setString(1, register.getId());
			prepStatement.setString(2, register.getFirstName());
			prepStatement.setString(3, register.getLastName());
			prepStatement.setString(4, register.getEmail());
			
			
			String encryptPassword = passwordUtils.generateSecurePassword(register.getPassword(),
					passwordUtils.getSalt(30));
			prepStatement.setString(5, encryptPassword);
			int result = prepStatement.executeUpdate();
			prepStatement.close();
			if (result > 0) {
				connection.commit();
				System.out.println("reg hash: " + connection.hashCode());
				Login login = new Login();
				login.setUserName(register.getEmail());
				login.setPassword(encryptPassword);
				login.setRegidfk(register.getId());
				String status = loginRepository.addCredentials(login);
				System.out.println("reg status: " + status);
				if (status.equals("success")) {
					
					return "success";
				} else {
					prepStatement.getConnection().rollback();
					return "fail";
				}

			} else {
				prepStatement.getConnection().rollback();
				return "fail";
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
		return "fail";
		
	}

	@Override
	public String updateUser(String id) throws IdNotFoundException, InvalidNameException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String selectStatement = "select * from register where regId=?";
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			// to retrieve the data
			// RS will hold the complete result
			
			resultSet =  preparedStatement.executeQuery();
			
			// RS object its a single one which is holding all the records
			// do we need to traverse it? ===> yes
			// 
			while (resultSet.next()) {
				// next method is used to traverse the RS
				/// initially RS will be places just above the 1st rec.
				// when u will call 1st time rs will retrieve the 1st rec & 
				// it will refer the 2nd one.
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				
				return Optional.of(register);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Optional.empty();
	}

	
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = "delete from register where regId=?";
		
        try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			// do we need to provide the values against ? placeholder?
			preparedStatement.setString(1,id);
			int result =preparedStatement.executeUpdate();
			// the no of rows afftected by the DML statement
			// 1 : one row is inserted
			// 
			if(result>0) {
				return "success"	;
			}
			else
				return "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}



	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Register> arrayList=new ArrayList<>();
		String selectStatement = "select * from register";
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			//preparedStatement.setString(1, id);
			
			// to retrieve the data
			// RS will hold the complete result
			
			resultSet =  preparedStatement.executeQuery();
			
			// RS object its a single one which is holding all the records
			// do we need to traverse it? ===> yes
			// 
			while (resultSet.next()) {
				// next method is used to traverse the RS
				/// initially RS will be places just above the 1st rec.
				// when u will call 1st time rs will retrieve the 1st rec & 
				// it will refer the 2nd one.
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				arrayList.add(register);
				
				
			}
			return Optional.ofNullable(arrayList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.empty();
	}

	@Override
	public Register[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Optional<List<Register>> optional=getAllUserDetails();
		if(optional.isEmpty()) {
			return null;
		}else {
			List<Register> list=optional.get();
			Register[] registers=new Register[list.size()];
			return list.toArray(registers);
		}
	}

	
	}


