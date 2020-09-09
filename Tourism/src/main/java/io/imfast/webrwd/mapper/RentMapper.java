package io.imfast.webrwd.mapper;

import java.sql.ResultSet;

import io.imfast.webrwd.model.Rent;

public class RentMapper implements RowMapper<Rent> {

	@Override
	public Rent MapRow(ResultSet rs) {
		try {
				Rent rent = new Rent();
				rent.setRentID(rs.getLong("RentID"));
				rent.setUserID(rs.getLong("UserID"));
				rent.setItemID(rs.getLong("ItemID"));
				rent.setRentDetail(rs.getString("RentDetail"));
				rent.setCost(rs.getString("Cost"));
				rent.setStatus(rs.getInt("status"));
				return rent;
			}catch(Exception e) {
				return null;
			}
	}

}
