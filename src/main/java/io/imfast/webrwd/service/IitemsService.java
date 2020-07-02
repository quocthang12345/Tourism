package io.imfast.webrwd.service;

import java.util.List;

import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.paging.Pagible;

public interface IitemsService {
	List<Items> FindByBusinessID(Long BusinessID);
	Items Insert(Items item);
	void Update(Items item);
	void Delete(long[] ids);
	List<Items> FindAll(Pagible pagible);
	int getTotalItem();
	int getTotalItemSortByBusinessID(Long BusinessID);
	Items Findone(Long id);
	List<Items> sortAll(String sortBy);
	List<Items> FindAll();
	List<Items> FindByNameItem(String NameItem);
}
