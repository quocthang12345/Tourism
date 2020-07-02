package io.imfast.webrwd.service.impl;

import java.util.List;

import javax.inject.Inject;

import io.imfast.webrwd.dao.IBusinessDAO;
import io.imfast.webrwd.model.BusinessAreas;
import io.imfast.webrwd.service.IBusinessService;

public class BusinessService implements IBusinessService {

/*	private IBusinessDAO businessdao;
	public BusinessAService() {
		businessdao = new BusinessDAO();
	}*/// su dung thuan de thuc hien ket cau dependency injection
	@Inject IBusinessDAO businessdao; // su dung Context Dependency Injection (CDI)
	@Override
	public List<BusinessAreas> FindAll() {
		// TODO Auto-generated method stub
		return businessdao.FindAll();
	}
	public BusinessAreas FindOne(Long id) {
		return businessdao.FindOne(id);
	}
	@Override
	public BusinessAreas FindByCode(String code) {
		// TODO Auto-generated method stub
		return businessdao.FindByCode(code);
	}

	
	

}
