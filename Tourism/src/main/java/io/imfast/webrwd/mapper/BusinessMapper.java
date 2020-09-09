package io.imfast.webrwd.mapper;

import java.sql.ResultSet;

import io.imfast.webrwd.model.BusinessAreas;

public class BusinessMapper implements RowMapper<BusinessAreas> {

	@Override
	public BusinessAreas MapRow(ResultSet rs) {
		try {
		BusinessAreas b = new BusinessAreas();
		b.setBusinessID(rs.getLong("BusinessID"));
		b.setName(rs.getString("Name"));
		b.setCode(rs.getString("Code"));
		return b;
		}catch(Exception e) {
			return null;
		}
	}

}
