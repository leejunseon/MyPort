package myport.service;

import java.util.List;

import myport.domain.CountryVo;
import myport.domain.UserVo;

public interface CountryService {

	public List<CountryVo> retrieveCountries(UserVo vo);

	public int addCountry(CountryVo vo);
	
}
