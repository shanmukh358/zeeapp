package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.Seriesrepo2;
import com.zee.zee5app.utils.DBUtils;

@Repository

public class Seriesrepoimpl implements Seriesrepo2 {
	private TreeSet<Series> set = new TreeSet<>();
	DBUtils dbUtils = null;

		private static Seriesrepo2 seriesrepository;
		public static Seriesrepo2 getInstance() throws IOException {
			if(seriesrepository==null)
				seriesrepository = new Seriesrepoimpl();
			return seriesrepository;
		}
		
		private Seriesrepoimpl() throws IOException {
			dbUtils = DBUtils.getInstance();
		}

		@Override
		public String addSeries(Series series) {
			Connection connection = dbUtils.getConnection();
			PreparedStatement preparedStatement;

			String insertStatetment = "insert into series"
					+ "(id,seriesName,cast,genre,length,releaseDate,language)" + "values(?,?,?,?,?,?)";

	// "(id,ageLimit,cast,genre,length,trailer,releaseDate,language,noOfEpisodes)" 
			try {
				preparedStatement = connection.prepareStatement(insertStatetment);

				preparedStatement.setString(1, series.getSid());
				preparedStatement.setString(2, series.getSname());
				preparedStatement.setString(3, series.getScast());
				preparedStatement.setString(4, series.getScat());
				preparedStatement.setInt(5, series.getSlength());
     			preparedStatement.setString(6, series.getStrailer());
				preparedStatement.setString(7, series.getSdor());
				preparedStatement.setString(8, series.getSlanguage());

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
		public String deleteSeriesById(String id) {
			// TODO Auto-generated method stub
			Connection connection = dbUtils.getConnection();
			PreparedStatement preparedStatement;
			String deleteStatetment = "delete from series where id=?";
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
		public String updateSeries(String id, Series series) throws NameNotFoundException, LocationNotFoundException {
			// TODO Auto-generated method stub
			Optional<Series> optional = this.getSeriesById(id);
			if(optional.isPresent()) {
				boolean result = set.remove(optional.get());
				set.add(series);
				if(result) {
					return null;
				}
				
			}
			return null;
		}

		@Override
		public Optional<Series> getSeriesById(String id) throws NameNotFoundException, LocationNotFoundException {
			// TODO Auto-generated method stub
			Connection connection = dbUtils.getConnection();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			String selectStatement = "select * from series where id=?";

			try {
				preparedStatement = connection.prepareStatement(selectStatement);
				preparedStatement.setString(1, id);

				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {

					Series Series = new Series();
					Series.setSid(resultSet.getString("id"));
					Series.setSname(resultSet.getString("seriesName"));
					Series.setScast(resultSet.getString("cast"));
					Series.setScat(resultSet.getString("genre"));
					Series.setSlength(resultSet.getInt("length"));
					Series.setSdor(resultSet.getString("releaseDate"));
					Series.setSlanguage(resultSet.getString("language"));
					return Optional.of(Series);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtils.closeConnection(connection);
			}

			return Optional.empty();
		}

		@Override
		public Optional<ArrayList<Series>> getAllSeries() throws LocationNotFoundException, NameNotFoundException  {
			// TODO Auto-generated method stub
			Connection connection = dbUtils.getConnection();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ArrayList<Series> arrayList = new ArrayList<>();

			String selectStatement = "select * from series";

			try {
				preparedStatement = connection.prepareStatement(selectStatement);

				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {

					Series Series = new Series();
					Series.setSid(resultSet.getString("id"));
					Series.setSname(resultSet.getString("seriesName"));
					Series.setScast(resultSet.getString("cast"));
					Series.setScat(resultSet.getString("genre"));
					Series.setSlength(resultSet.getInt("length"));
					Series.setSdor(resultSet.getString("releaseDate"));
					Series.setSlanguage(resultSet.getString("language"));
					arrayList.add(Series);
				}
				return Optional.ofNullable(arrayList);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbUtils.closeConnection(connection);
			}

			return Optional.empty();
		}

}
