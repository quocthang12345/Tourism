package io.imfast.webrwd.dao;

import java.util.List;

import io.imfast.webrwd.mapper.RowMapper;

public interface GenericDAO<T> {

	<T>List<T>query(String sql, RowMapper<T> rm, Object...parameters);
	Long Insert(String sql,Object...parameters);
	void Update(String sql,Object...parameters); // use to update and delete
	int Count(String sql,Object...parameters );
}
