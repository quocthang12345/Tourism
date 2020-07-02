package io.imfast.webrwd.dao;

import io.imfast.webrwd.model.Rent;

public interface IRentDAO extends GenericDAO<Rent> {
	Long Insert (Rent rent);
	Rent FindOne(Long id);
}
