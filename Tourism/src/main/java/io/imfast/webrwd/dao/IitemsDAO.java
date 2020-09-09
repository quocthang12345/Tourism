package io.imfast.webrwd.dao;

import java.util.List;

import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.paging.Pagible;

public interface IitemsDAO extends GenericDAO<Items> {
	List<Items>FindByBusinessID(Long BusinessID);
	Long Insert(Items item);
	Items FindOne(Long id);
	void Update(Items item);
	void Delete(long id);
	List<Items> FindAll(Pagible pagible);
	int getTotalItem();
	int getTotalItemSortByBusinessID(Long BusinessID);
	List<Items> FindAll();
	List<Items> sortAll(String sortBy);
	List<Items> FindByNameItem(String NameItem);
}
