package io.imfast.webrwd.paging;

import io.imfast.webrwd.sorter.Sorter;

public interface Pagible {
	Integer getPage();
	Integer getMaxPage();
	Integer getOffset();
	Sorter getSorter();
}
