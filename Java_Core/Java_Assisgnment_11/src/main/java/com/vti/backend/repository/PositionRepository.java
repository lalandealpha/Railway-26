package com.vti.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.basic.Pos;

public class PositionRepository {
	
	public Pos getPositionById(Connection connection, int id) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM Position WHERE PositionID = ?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			if (resultSet.getString(2).equals("Admin")) {
				return Pos.ADMIN;
			} else if (resultSet.getString(2).equals("Mentor")) {
				return Pos.MENTOR;
			} else {
				return Pos.STUDENT;
			}
		}
		return null;
	}

	public Pos getPositionByName(Connection connection, String name) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM Position WHERE PositionName = ?");
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			if (resultSet.getString(2).equals("Admin")) {
				return Pos.ADMIN;
			} else if (resultSet.getString(2).equals("Mentor")) {
				return Pos.MENTOR;
			} else {
				return Pos.STUDENT;
			}
		}
		return null;
	}

	public int getPositionIdByName(Connection connection, String name) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT PositionID FROM Position WHERE PositionName = ?");
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			return resultSet.getInt(1);
		}
		return 0;
	}
}
