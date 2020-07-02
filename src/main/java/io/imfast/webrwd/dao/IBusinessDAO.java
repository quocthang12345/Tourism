package io.imfast.webrwd.dao;

import java.util.List;

import io.imfast.webrwd.model.BusinessAreas;

public interface IBusinessDAO extends GenericDAO<BusinessAreas> {
	List<BusinessAreas> FindAll();
	BusinessAreas FindOne(Long id); 
	BusinessAreas FindByCode(String code);

}