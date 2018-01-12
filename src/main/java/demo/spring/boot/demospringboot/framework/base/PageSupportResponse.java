package demo.spring.boot.demospringboot.framework.base;

//分页支持的response
public class PageSupportResponse<T> extends BaseResponse<T> {
	public PageSupport pageSupport;

	public PageSupport getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}

	@Override
	public String toString() {
		return super.toString()+"PageSupportResponse [pageSupport=" + pageSupport + "]";
	}

	
}
