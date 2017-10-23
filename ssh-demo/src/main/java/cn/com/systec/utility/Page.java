package cn.com.systec.utility;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
public class Page {
    private static final int DEFAULT_PAGE_SIZE = 20;
    
    // 当前页码，从1开始
    private Integer pageNum;
    // 每页显示的记录数
    
    private Integer pageSize;
    // 总记录数
    private int totalRecord;
    // 记录
    private List<List> data;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setData(List data) {
        this.data = data;
    }
    
    @SuppressWarnings("rawtypes")
    public List getData() {
        return data;
    }
    
    @SuppressWarnings("rawtypes")
    public Page() {
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
    }
    
    @SuppressWarnings("rawtypes")
    public Page(int pageNum, int totalRecord, List data) {
        this(pageNum, totalRecord, DEFAULT_PAGE_SIZE, data);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Page(int pageNum, int totalRecord, int pageSize, List data) {
        this.pageNum = (pageNum <= 0 ? 1 : pageNum);
        this.pageSize = (pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize);
        this.totalRecord = totalRecord;
        this.data = data;
    }
    
    /**
     * 获取总页数
     * @return
     */
    public long getTotalPage() {
        if (getTotalRecord() % getPageSize() == 0)
            return getTotalRecord() / getPageSize();
        else
            return getTotalRecord() / getPageSize() + 1;
    }
    
    /**
     * 判断是否有前一页
     * @return
     */
    public boolean isHasPreviousPage() {
        return getPageNum() > 1;
    }
    
    /**
     * 判断是否有后一页
     * @return
     */
    public boolean isHasNextPage() {
        return getPageNum() < getTotalRecord();
    }
    
    /**
     * 获取任一页第一条记录在数据集中的位置
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static int getStartOfPage(int pageNum, int pageSize) {
        if (pageNum <= 0)
            pageNum = 1;
        
        if (pageSize <= 0)
            pageSize = DEFAULT_PAGE_SIZE;
        
        return (pageNum - 1) * pageSize;
    }
    
    /**
     * 获取任一页第一条记录在数据集中的位置（使用默认分页大小）
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static int getStartOfPage(int pageNum) {
        return getStartOfPage(pageNum, DEFAULT_PAGE_SIZE);
    }

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalRecord=" + totalRecord + ", data=" + data
				+ "]";
	}
    
}
