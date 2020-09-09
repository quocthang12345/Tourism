package io.imfast.webrwd.dao.impl;

import io.imfast.webrwd.dao.IVisitorDAO;
import io.imfast.webrwd.model.Visitor;

public class VisitorDAO extends AbstractDAO<Visitor> implements IVisitorDAO {

	@Override
	public Long Insert(Visitor visitor) {
		String sql = "INSERT INTO visitor(Username,Address,Telephone,RentID,Email) VALUES (?,?,?,?,?) ";
		return Insert(sql, visitor.getUsername(), visitor.getAddress(), visitor.getTelephone(), visitor.getRentID(), visitor.getEmail());
	}

}
