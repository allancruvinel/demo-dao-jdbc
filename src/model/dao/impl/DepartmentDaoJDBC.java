package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO department (Name) VALUES (?)"
			);
			st.setString(1, obj.getName());
			int rows = st.executeUpdate();
			
			if(rows<1) {
				throw new DbException("no rows affected");
			}
			else {
				System.out.println(rows+" rows affected");
			}
			
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE department SET Name = ? WHERE Id = ?"
					);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			int rows = st.executeUpdate();
			
			System.out.println(rows + " rows affected");
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
		st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
		st.setInt(1, id);
		
		int rows = st.executeUpdate();
		
		System.out.println(rows + " rows affected");
		
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT Name FROM department WHERE Id = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			if(rs.next()) {
			Department dep = new Department(id,rs.getString("Name"));
			return dep;
			}
			return null;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM department");
			
			rs = st.executeQuery();
			while(rs.next()) {
			Department dep = new Department(rs.getInt("Id"),rs.getString("Name"));
			list.add(dep);
			}
			return list;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}
}
