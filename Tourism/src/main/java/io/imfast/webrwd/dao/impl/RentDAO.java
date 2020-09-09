package io.imfast.webrwd.dao.impl;

import java.util.List;

import io.imfast.webrwd.dao.IRentDAO;
import io.imfast.webrwd.mapper.RentMapper;
import io.imfast.webrwd.mapper.itemsMapper;
import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.model.Rent;

public class RentDAO extends AbstractDAO<Rent> implements IRentDAO {

	
	
	@Override
	public Long Insert(Rent rent) {
		String sql = "INSERT INTO rent(UserID,ItemID,RentDetail,Cost,createDate,createBy,status) VALUES (?,?,?,?,?,?,?) ";
		return Insert(sql, rent.getUserID(),rent.getItemID(),rent.getRentDetail(),rent.getCost(),rent.getCreateDate(),rent.getCreateBy(),rent.getStatus());
	}

	@Override
	public Rent FindOne(Long id) {
		String sql = "SELECT * FROM rent WHERE RentID = ?";
	    List<Rent> rent = query(sql,new RentMapper(),id);
	    return rent.isEmpty() ? null : rent.get(0);
	}

}
