package cn.com.systec.utility;

import java.util.ArrayList;
import java.util.List;

public final class ConditionList {
	private List<Object[]> condList = new ArrayList<Object[]>();
	
	public ConditionList add(Object[] objArray) {
		condList.add(objArray);
		return this;
	}
	
	public List<Object[]> toList() {
		return this.condList;
	}
}
