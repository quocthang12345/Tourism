package io.imfast.webrwd.service;

import java.util.List;

import io.imfast.webrwd.model.BusinessAreas;

public interface IBusinessService {
	List<BusinessAreas> FindAll();
	BusinessAreas FindOne(Long id);
	BusinessAreas FindByCode(String code);
}
