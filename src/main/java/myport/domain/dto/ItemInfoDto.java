package myport.domain.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ItemInfoDto {

	List<ItemDto> itemList;
	Map<String,Integer> assetNumList;
	
}
