package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.LinkedHashSet;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.zee.zee5app.Exception.IdNotFoundException;

import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.Exception.NameNotFoundException;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.Movierepo2;
import com.zee.zee5app.utils.DBUtils;

@Repository

public class Movierepoimpl implements Movierepo2 {
	private Set<Movie> set = new LinkedHashSet<>();
	DBUtils dbUtils = null;
	private Movierepoimpl() throws IOException {
		dbUtils = DBUtils.getInstance();
	}
	
	private static Movierepo2 movieRepository;
	public static Movierepo2 getInstance() throws IOException{
		if(movieRepository==null)
			movieRepository = new Movierepoimpl();
		return movieRepository;
	}
	
	@Override
	public String addMovie(Movie movie) {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into movie"
				+ "(id,name,genre,language,trailer,cast,length,releaseDate)" + "values(?,?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			preparedStatement.setString(1, movie.getMid());
			preparedStatement.setString(2, movie.getMname());
			preparedStatement.setString(3, movie.getMcat());
			preparedStatement.setString(4, movie.getMlanguage());
			preparedStatement.setString(5, movie.getMtrailer());
			preparedStatement.setString(6, movie.getMcast());
			preparedStatement.setInt(7, movie.getMlength());
			preparedStatement.setString(8, movie.getMdor());

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
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from movie where id=?";
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
	public String updateMovie(String id,Movie movie) throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional = this.getMovieById(id);
		if(optional.isPresent()) {
			boolean result = set.remove(optional.get());
			set.add(movie);
			if(result) {
				return null;
			}
			
		}
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Movie Movie = new Movie();
				Movie.setMid(resultSet.getString("id"));
				Movie.setMname(resultSet.getString("name"));
				Movie.setMcat(selectStatement);
				Movie.setMlanguage(resultSet.getString("language"));
				Movie.setMtrailer(resultSet.getString("trailer"));
				Movie.setMcast(resultSet.getString("cast"));
				Movie.setMlength(resultSet.getInt("length"));
				Movie.setMdor(resultSet.getString("releaseDate"));
				return Optional.of(Movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public Optional<ArrayList<Movie>> getAllMovie() throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Movie> arrayList = new ArrayList<>();
		String selectStatement = "select * from movies";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Movie Movie = new Movie();
				Movie.setMid(resultSet.getString("id"));
				Movie.setMname(resultSet.getString("name"));
				Movie.setMcat(selectStatement);
				Movie.setMlanguage(resultSet.getString("language"));
				Movie.setMtrailer(resultSet.getString("trailer"));
				Movie.setMcast(resultSet.getString("cast"));
				Movie.setMlength(resultSet.getInt("length"));
				Movie.setMdor(resultSet.getString("releaseDate"));
				arrayList.add(Movie);
			}
			return Optional.ofNullable(arrayList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	

	@Override
	public Optional<Movie> getMovieByName(String name) throws LocationNotFoundException, NameNotFoundException {
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from movies where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, name);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Movie Movie = new Movie();
				Movie.setMid(resultSet.getString("id"));
				Movie.setMname(resultSet.getString("name"));
				Movie.setMcat(resultSet.getString("genre"));
				Movie.setMlanguage(resultSet.getString("language"));
				Movie.setMtrailer(resultSet.getString("trailer"));
				Movie.setMcast(resultSet.getString("cast"));
				Movie.setMlength(resultSet.getInt("length"));
				Movie.setMdor(resultSet.getString("releaseDate"));
				return Optional.of(Movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}

	@Override
	public String watchMovie(String moviename) throws NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
