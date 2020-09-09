package io.imfast.webrwd.dao.impl;

import java.util.List;

import io.imfast.webrwd.dao.IBusinessDAO;
import io.imfast.webrwd.mapper.BusinessMapper;
import io.imfast.webrwd.model.BusinessAreas;

public class BusinessDAO extends AbstractDAO<BusinessAreas> implements IBusinessDAO {

	@Override
	public List<BusinessAreas> FindAll() {
		String sql = "SELECT * FROM businessareas";
		return query(sql,new BusinessMapper());
	}

	@Override
	public BusinessAreas FindOne(Long id) {
		String sql = "SELECT * FROM businessareas WHERE BusinessID = ?";
	    List<BusinessAreas> bs = query(sql,new BusinessMapper(),id);
	    return bs.isEmpty() ? null : bs.get(0);
	}

	@Override
	public BusinessAreas FindByCode(String code) {
		String sql = "SELECT * FROM businessareas WHERE Code = ?";
	    List<BusinessAreas> bs = query(sql,new BusinessMapper(),code);
	    return bs.isEmpty() ? null : bs.get(0);
	}
}
