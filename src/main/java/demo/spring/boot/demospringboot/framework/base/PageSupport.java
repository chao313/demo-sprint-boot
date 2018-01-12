package demo.spring.boot.demospringboot.framework.base;

public class PageSupport {
	// 当前页的index
	Integer pageIndex;
	// 每页的record数量
	Integer onePageRecord;
	// 一共的页数
	Integer totalPage;
	// 一共的条数
	Integer totalCount;

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getOnePageRecord() {
		return onePageRecord;
	}

	public void setOnePageRecord(Integer onePageRecord) {
		this.onePageRecord = onePageRecord;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PageSupport [pageIndex=" + pageIndex + ", onePageRecord=" + onePageRecord + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + "]";
	}

}