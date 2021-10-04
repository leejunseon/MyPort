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
import myport.domain.CountryVo;
import myport.domain.UserVo;
import myport.service.CountryService;

@RestController
@RequestMapping("/country/*")
@AllArgsConstructor
public class CountryController {

	private CountryService service;

	@GetMapping(value = "/{uNo}", produces = "application/json; charset=UTF8")
	public List<CountryVo> get(@PathVariable("uNo") Long uNo) {
		UserVo paramVo = new UserVo();
		paramVo.setUNo(uNo);
		return service.retrieveCountries(paramVo);
	}

	@PostMapping(value="/add",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String register(@RequestBody CountryVo vo) throws Exception{
		int insertCount=service.addCountry(vo);
		return insertCount==1?"success":"fail";
	}
	
	@PostMapping(value="/modify",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@RequestBody List<CountryVo> voList) throws Exception{
		int modifyCount=service.modifyCountries(voList);
		return modifyCount>0?"success":"fail";
	}
	
	@PostMapping(value="/delete",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String delete(@RequestBody List<CountryVo> voList) throws Exception{
		int deleteCount=service.deleteCountries(voList);
		return deleteCount>0?"success":"fail";
	}
}
