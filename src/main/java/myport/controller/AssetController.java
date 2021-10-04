package myport.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import myport.domain.AssetVo;
import myport.domain.UserVo;
import myport.service.AssetService;

@RestController
@RequestMapping("/asset/*")
@AllArgsConstructor
public class AssetController {

	private AssetService service;

	@GetMapping(value = "/{uNo}", produces = "application/json; charset=UTF8")
	public List<AssetVo> retrieve(@PathVariable("uNo") Long uNo) {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(uNo);
		return service.retrieveAssets(paramVo);
	}
	
	@PostMapping(value="/add",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String register(@RequestBody AssetVo vo) throws Exception{
		int insertCount=service.addAsset(vo);
		return insertCount==1?"success":"fail";
	}
	
	@PostMapping(value="/modify",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@RequestBody List<AssetVo> voList) throws Exception{
		int modifyCount=service.modifyAssets(voList);
		return modifyCount>0?"success":"fail";
	}
	
	@PostMapping(value="/delete",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String delete(@RequestBody List<AssetVo> voList) throws Exception{
		int deleteCount=service.deleteAssets(voList);
		return deleteCount>0?"success":"fail";
	}

}
