package com.moravia.hs.base.entity.other;

/*Financial statement filter by department or costcenter*/
@Deprecated
public class FinancialStatement_SumSeason {

	private String departName;
	private Double costSum;

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Double getCostSum() {
		return costSum;
	}

	public void setCostSum(Double costSum) {
		this.costSum = costSum;
	}

}
