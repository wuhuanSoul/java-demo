package cn.com.systec.utility;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public final class QueryCondition implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3984485723603070700L;

	@JsonProperty("page_size")
    private Integer pageSize;
    
    @JsonProperty("page_no")
    private Integer pageNo;
    
    @JsonProperty("conditions")
    private List<Object[]> conditions;
    
    public Integer getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    public Integer getPageNo() {
        return pageNo;
    }
    
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    
    public List<Object[]> getConditions() {
        if (CommonFunctions.isNull(conditions)) {
            conditions = new ArrayList<Object[]>();
        }
        
        return conditions;
    }
    
    public void setConditions(List<Object[]> conditions) {
        this.conditions = conditions;
    }
}
