package myport.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import myport.domain.dto.ItemDto;
import myport.domain.vo.ItemVo;
import myport.domain.vo.UserVo;
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
	
	@GetMapping(value = "/{uNo}", produces = "application/json; charset=UTF8")
	public ItemDto get(@PathVariable("uNo") Long uNo) {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(uNo);
		return service.retrieveItems(paramVo);
	}

}
