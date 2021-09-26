package myport.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
