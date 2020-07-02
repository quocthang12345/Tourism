package io.imfast.webrwd.model;

public class HistoryRent extends Abstract<HistoryRent> {
	private Long HistoryID;
	private String ItemName;
	private int NumOfRent;
	private int TotalCost;
	public Long getHistoryID() {
		return HistoryID;
	}
	public void setHistoryID(Long historyID) {
		HistoryID = historyID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getNumOfRent() {
		return NumOfRent;
	}
	public void setNumOfRent(int numOfRent) {
		NumOfRent = numOfRent;
	}
	public int getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(int totalCost) {
		TotalCost = totalCost;
	}
	
	
}
