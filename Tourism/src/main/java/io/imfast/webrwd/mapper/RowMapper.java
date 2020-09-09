package io.imfast.webrwd.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	T MapRow(ResultSet rs);
}
