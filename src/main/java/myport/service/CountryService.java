package myport.service;

import java.util.List;

import myport.domain.vo.CountryVo;
import myport.domain.vo.UserVo;

public interface CountryService {

	public List<CountryVo> retrieveCountries(UserVo vo);

	public int addCountry(CountryVo vo);
	
	public int modifyCountries(List<CountryVo> voList);
	
	public int deleteCountries(List<CountryVo> voList);
	
}
