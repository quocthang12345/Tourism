package io.imfast.webrwd.paging;

import io.imfast.webrwd.sorter.Sorter;

public class PageRequest implements Pagible {

	private Integer page;
	private Integer maxPage;
	private Sorter sorter;
	
	public PageRequest(Integer page, Integer maxPage, Sorter sorter){
		this.page = page;
		this.maxPage = maxPage;
		this.sorter = sorter;
	}
	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public Integer getMaxPage() {
		// TODO Auto-generated method stub
		return maxPage;
	}

	@Override
	public Integer getOffset() {
		if(this.maxPage != null) {
			return ((this.page - 1) * this.maxPage);
		}
		return null;
	}
	@Override
	public Sorter getSorter() {
		if(this.sorter != null) {
			return this.sorter;
		}
		return null;
	}

}
