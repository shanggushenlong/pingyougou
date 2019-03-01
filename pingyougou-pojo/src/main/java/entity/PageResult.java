package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果类
 * @author wuchaoqun
 *
 */
public class PageResult implements Serializable{
	
	private long total; //总记录数
	private List rows;//当前页结果数
	public final long getTotal() {
		return total;
	}
	public final void setTotal(long total) {
		this.total = total;
	}
	public final List getRows() {
		return rows;
	}
	public final void setRows(List rows) {
		this.rows = rows;
	}
	public PageResult(long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
}
