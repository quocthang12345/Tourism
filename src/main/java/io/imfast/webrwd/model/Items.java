package io.imfast.webrwd.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Items extends Abstract<Items> {
	@JsonProperty("ItemID")
	private Long ItemID;
	@JsonProperty("NameItem")
	private String NameItem;
	@JsonProperty("Thumbnail")
	private String Thumbnail;
	@JsonProperty("ItemDetail")
	private String ItemDetail;
	@JsonProperty("TotalPrice")
	private String TotalPrice;
	@JsonProperty("BusinessID")
	private Long BusinessID;
	@JsonProperty("CooperatorID")
	private Long CooperatorID;
	@JsonProperty("Ids")
	private long[] Ids;
	@JsonProperty("BusinessCode")
	private String BusinessCode;
	
	public Long getItemID() {
		return ItemID;
	}
	
	public long[] getIds() {
		return Ids;
	}

	public void setIds(long[] ids) {
		Ids = ids;
	}

	public void setItemID(Long itemID) {
		ItemID = itemID;
	}
	public String getNameItem() {
		return NameItem;
	}
	public void setNameItem(String nameItem) {
		NameItem = nameItem;
	}
	public String getThumbnail() {
		return Thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		Thumbnail = thumbnail;
	}
	public String getItemDetail() {
		return ItemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.ItemDetail = itemDetail;
	}
	public String getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.TotalPrice = totalPrice;
	}
	public Long getBusinessID() {
		return BusinessID;
	}
	public void setBusinessID(Long businessID) {
		BusinessID = businessID;
	}
	public Long getCooperatorID() {
		return CooperatorID;
	}
	public void setCooperatorID(Long cooperatorID) {
		CooperatorID = cooperatorID;
	}


	public String getBusinessCode() {
		return BusinessCode;
	}

	public void setBusinessCode(String businessCode) {
		BusinessCode = businessCode;
	}
	
	
	
}
