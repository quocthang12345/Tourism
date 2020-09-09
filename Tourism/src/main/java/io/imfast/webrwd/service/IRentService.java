package io.imfast.webrwd.service;

import io.imfast.webrwd.model.Rent;

public interface IRentService {
	Long Insert(Rent rent);
	Rent Findone(Long id);
}
