package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.Subrepo2;
import com.zee.zee5app.utils.DBUtils;

@Repository

public class Subrepoimpl implements Subrepo2 {
	private List<Subscription> set = new ArrayList<>();
	DBUtils dbUtils = null;
    private Subrepoimpl() throws IOException {
    	dbUtils = DBUtils.getInstance();
	}
	
	private static Subrepo2 subscriptionRepository;
	public static Subrepo2 getInstance() throws IOException {
		if(subscriptionRepository==null)
			subscriptionRepository = new Subrepoimpl();
		
		return subscriptionRepository;
	
	}
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into subscription"
				+ "(id,type,dop,status,country,amount,paymentmode,autorenewal,doe,regIdfk)" + "values(?,?,?,?,?,?,?,?,?,?)";
//id,type,dop,status,country,amount,paymentmode,autorenewal,doe,regIdfk
		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			preparedStatement.setString(1, subscription.getId());
			preparedStatement.setString(2, subscription.getType());
			preparedStatement.setString(3, subscription.getDop());
			preparedStatement.setString(4, subscription.getStatus());
			preparedStatement.setString(5, subscription.getCountry());
			preparedStatement.setString(6, subscription.getPayAmount());
			preparedStatement.setString(7, subscription.getPaymentmode());
			preparedStatement.setString(8, subscription.getAutorenewal());
			preparedStatement.setString(9, subscription.getDoe());
			preparedStatement.setString(10, subscription.getId());
			

			int result = preparedStatement.executeUpdate();
			
			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	@Override
	public String deleteSubscription(String id)  {

		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from login where userName=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(deleteStatetment);
			preparedStatement.setString(1, id);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public String updateSubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws LocationNotFoundException, InvalidAmountException  {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from subscription where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Subscription Sub = new Subscription();
				Sub.setId(resultSet.getString("id"));
				Sub.setDop(resultSet.getString("dop"));
				Sub.setDoe(resultSet.getString("expiry"));
				Sub.setPayAmount(resultSet.getString("amount"));
				Sub.setPaymentmode(resultSet.getString("paymentMode"));
				Sub.setStatus(resultSet.getString("status"));
				Sub.setType(resultSet.getString("type"));
				Sub.setAutorenewal(resultSet.getString("autoRenewal"));
				Sub.setId(resultSet.getString("regIdfk"));
				return Optional.of(Sub);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}
	@Override
	public Optional<ArrayList<Subscription>> getAllSubscription() throws LocationNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Subscription> arrayList = new ArrayList<>();

		String selectStatement = "select * from subscription";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Subscription Sub = new Subscription();
				Sub.setId(resultSet.getString("id"));
				Sub.setDop(resultSet.getString("dop"));
				Sub.setDoe(resultSet.getString("expiry"));
				Sub.setPayAmount(resultSet.getString("amount"));
				Sub.setPaymentmode(resultSet.getString("paymentMode"));
				Sub.setStatus(resultSet.getString("status"));
				Sub.setType(resultSet.getString("type"));
				Sub.setAutorenewal(resultSet.getString("autoRenewal"));
				Sub.setId(resultSet.getString("regId"));
				arrayList.add(Sub);

			}

			return Optional.ofNullable(arrayList); // since we are not 100% sure abt the outcome

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}
}


