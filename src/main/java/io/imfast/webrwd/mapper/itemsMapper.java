package io.imfast.webrwd.mapper;

import java.sql.ResultSet;

import io.imfast.webrwd.model.Items;

public class itemsMapper implements RowMapper<Items> {

	@Override
	public Items MapRow(ResultSet rs) {
		try {
			Items item = new Items();
			item.setItemID(rs.getLong("ItemID"));
			item.setNameItem(rs.getString("NameItem"));
			item.setThumbnail(rs.getString("Thumbnail"));
			item.setItemDetail(rs.getString("ItemDetail"));
			item.setTotalPrice(rs.getString("TotalPrice"));
			item.setCreateDate(rs.getTimestamp("createDate"));
			/*
			 * if(rs.getTimestamp("modifyDate") != null) {
			 * item.setModifyDate(rs.getTimestamp("modifyDate")); }
			 */
			item.setCreateBy(rs.getString("createBy"));
			/*
			 * if(rs.getString("modifyBy") != null) {
			 * item.setModifyBy(rs.getString("modifyBy")); }
			 */
			item.setBusinessID(rs.getLong("BusinessID"));
			item.setCooperatorID(rs.getLong("CooperatorID"));
		return item;
		}catch(Exception e) {
			return null;
		}
	}

}
