package io.imfast.webrwd.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import io.imfast.webrwd.dao.IitemsDAO;
import io.imfast.webrwd.model.BusinessAreas;
import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.paging.Pagible;
import io.imfast.webrwd.service.IBusinessService;
import io.imfast.webrwd.service.IitemsService;

public class itemsService implements IitemsService {

	@Inject
	private IitemsDAO itemsDAO;
	@Inject
	private IBusinessService businessDAO;
	@Override
	public List<Items> FindByBusinessID(Long BusinessID) {
		// TODO Auto-generated method stub
		return itemsDAO.FindByBusinessID(BusinessID);
	}
	@Override
	public Items Insert(Items item) {
		item.setCreateDate(new Timestamp(System.currentTimeMillis()));
		BusinessAreas bs = businessDAO.FindByCode(item.getBusinessCode());
		item.setBusinessID(bs.getBusinessID());
		Long id = itemsDAO.Insert(item);
		return itemsDAO.FindOne(id);
	}
	@Override
	public void Update(Items newItem) {
		Items oldItem = itemsDAO.FindOne(newItem.getItemID());
		newItem.setCreateDate(newItem.getCreateDate());
		newItem.setCreateBy(oldItem.getCreateBy());
		newItem.setModifyDate(new Timestamp(System.currentTimeMillis()));
		BusinessAreas bs = businessDAO.FindByCode(newItem.getBusinessCode());
		newItem.setBusinessID(bs.getBusinessID());
		itemsDAO.Update(newItem);
	}
	@Override
	public void Delete(long[] ids) {
		for(long id : ids) {
			itemsDAO.Delete(id);
		}
		
	}
	@Override
	public List<Items> FindAll(Pagible pagible) {
		return itemsDAO.FindAll(pagible);
	}
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return itemsDAO.getTotalItem();
	}
	@Override
	public Items Findone(Long id) {
		Items item = itemsDAO.FindOne(id);
		BusinessAreas bs = businessDAO.FindOne(item.getBusinessID());
		item.setBusinessCode(bs.getCode());
		return item;
	}
	@Override
	public List<Items> FindAll() {
		return itemsDAO.FindAll();
	}
	@Override
	public List<Items> sortAll(String sortBy) {
		// TODO Auto-generated method stub
		return itemsDAO.sortAll(sortBy);
	}
	@Override
	public int getTotalItemSortByBusinessID(Long BusinessID) {
		// TODO Auto-generated method stub
		return itemsDAO.getTotalItemSortByBusinessID(BusinessID);
	}
	@Override
	public List<Items> FindByNameItem(String NameItem) {
		// TODO Auto-generated method stub
		return itemsDAO.FindByNameItem(NameItem);
	}
}
