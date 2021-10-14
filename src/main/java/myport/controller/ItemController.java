package myport.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import myport.domain.vo.ItemVo;
import myport.service.ItemService;

@RestController
@RequestMapping("/item/*")
@AllArgsConstructor
public class ItemController {

	private ItemService service;
	
	@PostMapping(value="/add",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String register(@RequestBody ItemVo vo) throws Exception{
		int insertCount=service.addItem(vo);
		return insertCount==1?"success":"fail";
	}

}
