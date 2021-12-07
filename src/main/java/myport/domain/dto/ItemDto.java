package myport.domain.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class ItemDto {

	List<ItemDetail> itemList;
	Map<String,Integer> assetNumList;
	Set<String> countryList;
	Long maxRatio;
	
}
