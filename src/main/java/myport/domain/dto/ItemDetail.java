package myport.domain.dto;

import lombok.Data;

@Data
/*
 * ItemVo에서 Ratio 항목 추가
 * Ratio는 DB에서 관리하지 않고, Service에서 계산.
 */
public class ItemDetail {

	public Long iNo;
	public String cName;
	public String aName;
	public String iName;
	public Long iPrice;
	public Long iNum;
	public Long iRatio;
	
}
