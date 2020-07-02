package io.imfast.webrwd.dao.impl;


import java.util.List;

import io.imfast.webrwd.dao.IitemsDAO;
import io.imfast.webrwd.mapper.itemsMapper;
import io.imfast.webrwd.model.Items;
import io.imfast.webrwd.paging.Pagible;

public class itemsDAO extends AbstractDAO<Items> implements IitemsDAO {
	
	
	@Override
	public List<Items> FindByBusinessID(Long BusinessID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM items WHERE BusinessID = ?";
		return (List<Items>) query(sql,new itemsMapper(),BusinessID);
	}

	@Override
	public Long Insert(Items item) {
		String sql = "INSERT INTO items(NameItem,Thumbnail,ItemDetail,TotalPrice,createDate,createBy,BusinessID,CooperatorID) VALUES (?,?,?,?,?,?,?,?)";
		return Insert(sql,item.getNameItem(),item.getThumbnail(),item.getItemDetail(),item.getTotalPrice(),item.getCreateDate(),
				item.getCreateBy(),item.getBusinessID(), item.getCooperatorID());	
	}

	@Override
	public Items FindOne(Long id) {
		String sql = "SELECT * FROM items WHERE ItemID = ?";
	    List<Items> item = query(sql,new itemsMapper(),id);
	    return item.isEmpty() ? null : item.get(0);
	}
	
	@Override
	public void Update(Items item) {
		String sql = "UPDATE items SET NameItem=?,Thumbnail=?,ItemDetail=?,TotalPrice=?,createDate=?,modifyDate=?,createBy=?,modifyBy=?,BusinessID=?,CooperatorID=? WHERE ItemID = ?";
		Update(sql,item.getNameItem(),item.getThumbnail(),item.getItemDetail(),item.getTotalPrice(),item.getCreateDate(),item.getModifyDate(),
				item.getCreateBy(),item.getModifyBy(),item.getBusinessID(), item.getCooperatorID(),item.getItemID());
	}

	@Override
	public void Delete(long id) {
		String sql = "DELETE FROM items WHERE ItemID = ? ";
		Update(sql,id);
	}

	@Override
	public List<Items> FindAll(Pagible pagible) {
		StringBuilder sql = new StringBuilder("SELECT * FROM items ");
		if(pagible.getSorter().getSortName() != null && pagible.getSorter().getSortBy() != null) {
			sql.append(" ORDER BY "+pagible.getSorter().getSortName()+" "+ pagible.getSorter().getSortBy()+" ");
		}
		if(pagible.getOffset() != null && pagible.getMaxPage() != null) {
			sql.append(" LIMIT "+pagible.getOffset() +", "+pagible.getMaxPage()+" ");
		}
		return query(sql.toString(), new itemsMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT COUNT(*) FROM items";
		return Count(sql);
	}

	@Override
	public List<Items> FindAll() {
		String sql = "SELECT * FROM items";
		return query(sql,new itemsMapper());
	}

	@Override
	public List<Items> sortAll(String sortBy) {
		StringBuilder sql = new StringBuilder("SELECT * FROM items");
		if(sortBy != null) {
			sql.append(" ORDER BY TotalPrice " + sortBy + " ");
		}
		return query(sql.toString(), new itemsMapper());
	}

	@Override
	public int getTotalItemSortByBusinessID(Long BusinessID) {
		String sql = "SELECT COUNT(*) FROM items WHERE BusinessID = ? ";
		return Count(sql,BusinessID);
	}

	@Override
	public List<Items> FindByNameItem(String NameItem) {
		String sql = "SELECT * FROM items WHERE NameItem = ? ";
		return query(sql, new itemsMapper(), NameItem);
	}



}
