package io.imfast.webrwd.service.impl;

import javax.inject.Inject;

import io.imfast.webrwd.dao.IVisitorDAO;
import io.imfast.webrwd.model.Visitor;
import io.imfast.webrwd.service.IVisitorService;

public class VisitorService implements IVisitorService{
	@Inject
	IVisitorDAO visitorDAO;
	
	@Override
	public Long Insert(Visitor visitor) {
		return visitorDAO.Insert(visitor);
	}

}
