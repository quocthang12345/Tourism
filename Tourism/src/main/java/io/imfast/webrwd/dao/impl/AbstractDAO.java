package io.imfast.webrwd.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import io.imfast.webrwd.dao.GenericDAO;
import io.imfast.webrwd.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public Connection getConnection()
	{
		try {
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); // load driver 
			 * String url = "jdbc:mysql://localhost:101/tourism"; 
			 * String user = "root"; 
			 * String password = "quocthang123";
			 */
			
			Class.forName(resourceBundle.getString("driveName")); // load driver
			String url = resourceBundle.getString("url"); 
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url,user,password); // return connect to my db, if error return null
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rm, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			setParameter(ps,parameters);
			rs = ps.executeQuery();
			while(rs.next()) {
				results.add(rm.MapRow(rs));
			}
			return results;
		}catch(Exception e) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				return null;
			}
		}	
	}

	private void setParameter(PreparedStatement ps, Object...parameters) {
		try {
			for(int i = 0 ; i < parameters.length ; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if(parameter instanceof Long) {
					ps.setLong(index, (Long) parameter);
				}
				else if(parameter instanceof String) {
					ps.setString(index, (String) parameter);
				}
				else if(parameter instanceof Integer) {
					ps.setInt(index, (Integer) parameter);
				}
				else if(parameter instanceof Timestamp) {
					ps.setTimestamp(index, (Timestamp) parameter);
				}
				else if(parameter == null) {
					ps.setNull(index, Types.NULL);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Long Insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			setParameter(ps, parameters);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);
			}
			connection.commit();
		return id;
		}catch(Exception e) { 
		try {
			if(connection != null) {
				connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if(connection != null) connection.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(SQLException e2) {
				return null;
			}
		}
		return null;
	}

	@Override
	public void Update(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			setParameter(ps, parameters);
			ps.executeUpdate();
			connection.commit();
		}catch(Exception e) {
			try {
				if(connection != null) {
					connection.rollback();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if(connection != null) connection.close();
				if(ps != null) ps.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
			
		}
	}

	@Override
	public int Count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			int count = 0;
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			setParameter(ps,parameters);
			rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		}catch(Exception e) {
			return 0;
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				return 0;
			}
		}	
	}
}
