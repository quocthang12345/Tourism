package io.imfast.webrwd.dao;

import io.imfast.webrwd.model.Visitor;

public interface IVisitorDAO extends GenericDAO<Visitor> {
	Long Insert(Visitor visitor);
}
