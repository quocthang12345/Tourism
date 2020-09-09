package io.imfast.webrwd.service.impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import io.imfast.webrwd.dao.IRentDAO;
import io.imfast.webrwd.model.Rent;
import io.imfast.webrwd.service.IRentService;

public class RentService implements IRentService {

	@Inject
	IRentDAO rentDAO;
	@Override
	public Long Insert(Rent rent) {
		rent.setCreateDate(new Timestamp(System.currentTimeMillis()));
		return rentDAO.Insert(rent);
	}
	@Override
	public Rent Findone(Long id) {
		return rentDAO.FindOne(id);
	}

}
