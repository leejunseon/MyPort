package myport.service;

import java.util.List;

import myport.domain.CountryVo;
import myport.domain.UserVo;

public interface CountryService {

	public List<CountryVo> retrieveCountries(UserVo vo);

	public int addCountry(CountryVo vo);
	
	public int modifyCountries(List<CountryVo> voList);
	
	public int deleteCountries(List<CountryVo> voList);
	
}
